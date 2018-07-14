package com.github.yuri0x7c1.uxcrm.devtools.ui.menu.category;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
    @SideBarSection(id = DevtoolsCategories.DEVTOOLS, caption = "Devtools", order=1000),
})
public class DevtoolsCategories {
	public static final String DEVTOOLS = "devtools";
}