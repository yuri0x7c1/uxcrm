package com.github.yuri0x7c1.uxcrm.content.ui.menu.category;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
    @SideBarSection(id = CatalogCategories.CATALOG, caption = "Catalog", order=400),
})
public class CatalogCategories {
    public static final String CATALOG = "catalog";
}
