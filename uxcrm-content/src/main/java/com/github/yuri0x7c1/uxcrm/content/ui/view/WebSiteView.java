package com.github.yuri0x7c1.uxcrm.content.ui.view;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.webapp.website.WebSite;
import org.apache.ofbiz.webapp.website.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxcrm.content.ui.menu.category.ContentCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(parentId = ContentCategories.CONTENT, caption=WebSiteView.NAME, icon=VaadinIcons.BROWSER, order = 2)
@UIScope
@SpringView(name =  WebSiteView.NAME)
public class WebSiteView extends CommonView implements View {

	public static final String NAME = "Web Sites";

	@Autowired
	private WebSiteService webSiteService;

	private MTable<WebSite> webSiteTable = new MTable<>(WebSite.class)
		.withProperties(WebSite.Fields.webSiteId.name(), WebSite.Fields.siteName.name())
		.withFullWidth()
		.withFullHeight();

	public WebSiteView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
		addComponent(webSiteTable);
		setExpandRatio(webSiteTable, 1.0f);
	}

	@PostConstruct
    public void init() throws Exception {
		webSiteTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				List<WebSite> webSites = webSiteService.find(
						Integer.valueOf(firstRow),
						Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE),
						property != null ? Collections.singletonList(property + " " + (sortAscending ? "ASC" : "DESC")) : null,
						null);

				return webSites;
			},
			() -> {
				return webSiteService.count(null);
			}
		)
		.sort(new Object[] {WebSite.Fields.webSiteId.name()}, new boolean[] {true});
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
