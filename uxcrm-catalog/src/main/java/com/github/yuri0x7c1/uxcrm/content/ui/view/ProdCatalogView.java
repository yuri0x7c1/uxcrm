package com.github.yuri0x7c1.uxcrm.content.ui.view;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.product.catalog.ProdCatalog;
import org.apache.ofbiz.product.catalog.service.base.ProdCatalogBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.VaadinFontIcon;
import org.vaadin.viritin.LazyList;
import org.vaadin.viritinv7.fields.MTable;

import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxcrm.content.ui.menu.category.CatalogCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@VaadinFontIcon(VaadinIcons.LIST)
@SideBarItem(sectionId=CatalogCategories.CATALOG, caption=ProdCatalogView.NAME, order = 1)
@UIScope
@SpringView(name =  ProdCatalogView.NAME)
public class ProdCatalogView extends CommonView implements View {

	public static final String NAME = "Catalog";

	@Autowired
	private ProdCatalogBaseService prodCatalogService;

	private MTable<ProdCatalog> contentTable = new MTable<>(ProdCatalog.class)
		.withFullWidth()
		.withFullHeight();

	public ProdCatalogView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
		addComponent(contentTable);
		setExpandRatio(contentTable, 1.0f);
	}

	@PostConstruct
    public void init() throws Exception {
		contentTable.lazyLoadFrom(
			(firstRow, sortAscending, property) -> {
				List<ProdCatalog> prodCatalogs = prodCatalogService.find(
						Integer.valueOf(firstRow),
						Integer.valueOf(LazyList.DEFAULT_PAGE_SIZE),
						property != null ? Collections.singletonList(property + " " + (sortAscending ? "ASC" : "DESC")) : null,
						null);

				return prodCatalogs;
			},
			() -> {
				return prodCatalogService.count(null);
			}
		)
		.sort(new Object[] {ProdCatalog.Fields.prodCatalogId.name()}, new boolean[] {true});
    }
}