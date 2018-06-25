package com.github.yuri0x7c1.uxcrm.content.ui.view;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.content.content.ContentDataResourceView;
import org.apache.ofbiz.content.content.service.base.ContentDataResourceViewBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.VaadinFontIcon;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxcrm.content.ui.menu.category.ContentCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@VaadinFontIcon(VaadinIcons.BOOK)
@SideBarItem(sectionId=ContentCategories.CONTENT, caption=ContentView.NAME, order = 3)
@UIScope
@SpringView(name =  ContentView.NAME)
public class ContentView extends CommonView implements View {

	public static final String NAME = "Content";

	@Autowired
	private ContentDataResourceViewBaseService contentService;

	private MTable<ContentDataResourceView> contentTable = new MTable<>(ContentDataResourceView.class)
		.withProperties(
			ContentDataResourceView.Fields.contentId.name(),
			ContentDataResourceView.Fields.contentName.name(),
			ContentDataResourceView.Fields.contentTypeId.name(),
			ContentDataResourceView.Fields.dataResourceId.name(),
			ContentDataResourceView.Fields.drDataResourceName.name(),
			ContentDataResourceView.Fields.mimeTypeId.name()
		)
		.withFullWidth()
		.withFullHeight();

	public ContentView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
		addComponent(contentTable);
		setExpandRatio(contentTable, 1.0f);
	}

	@PostConstruct
    public void init() throws Exception {
		contentTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				List<ContentDataResourceView> webSites = contentService.find(
						Integer.valueOf(firstRow),
						Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE),
						property != null ? Collections.singletonList(property + " " + (sortAscending ? "ASC" : "DESC")) : null,
						null);

				return webSites;
			},
			() -> {
				return contentService.count(null);
			}
		)
		.sort(new Object[] {ContentDataResourceView.Fields.contentId.name()}, new boolean[] {true});
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
