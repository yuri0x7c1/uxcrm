package com.github.yuri0x7c1.uxcrm.common.ui.menu.category;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
    @SideBarSection(id = CommonCategories.COMMON, caption = "Common", order=100),
    @SideBarSection(id = CommonCategories.OPERATIONS, caption = "Operations")
})
public class CommonCategories {
    public static final String COMMON = "common";
    public static final String OPERATIONS = "operations";
}