package com.github.yuri0x7c1.uxerp.content.ui.view;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.common.service.PerformFindListService;
import org.apache.ofbiz.common.service.PerformFindListService.In;
import org.apache.ofbiz.common.service.PerformFindListService.Out;
import org.apache.ofbiz.webapp.website.entity.WebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.content.ui.config.CmsSections;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @VaadinFontIcon(VaadinIcons.EDIT)
@MenuItem(sectionId = CmsSections.CMS, caption=WebSiteView.NAME, order = 1)
@UIScope
@SpringView(name =  WebSiteView.NAME)
public class WebSiteView extends CommonView implements View {

	public static final String NAME = "WebSites";

	@Autowired
	public PerformFindListService performFindListService;

	private MTable<WebSite> webSiteTable = new MTable<>(WebSite.class)
			.withProperties("webSiteId", "siteName")
			.withFullWidth()
			.withFullHeight();

	public WebSiteView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
		addComponent(webSiteTable);
		setExpandRatio(webSiteTable, 1.0f);
	}

	@PostConstruct
	public void init() {
		In in = new In();
		in.setEntityName(WebSite.NAME);
		in.setInputFields(new HashMap<String, Object>());
		in.setNoConditionFind("Y");

		webSiteTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				in.setViewSize(LazyList.DEFAULT_PAGE_SIZE);
				in.setViewIndex(firstRow / LazyList.DEFAULT_PAGE_SIZE);

				if (property != null) {
					String sortField = property + " " + (sortAscending ? "ASC" : "DESC");
					in.setOrderBy(sortField);
				}
				else {
					in.setOrderBy(null);
				}

				Out out = performFindListService.runSync(in);
				List<WebSite> webSites = WebSite.fromValues(out.getList());

				return webSites;
			},
			() -> {
				in.setViewSize(1);
				in.setViewIndex(1);
				Out out = performFindListService.runSync(in);
				return out.getListSize();
			}
		)
		.sort(new Object[] {"webSiteId"}, new boolean[] {true});
	}

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
