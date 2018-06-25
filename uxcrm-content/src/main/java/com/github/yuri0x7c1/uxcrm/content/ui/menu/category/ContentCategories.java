package com.github.yuri0x7c1.uxcrm.content.ui.menu.category;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
    @SideBarSection(id = ContentCategories.CONTENT, caption = "Content", order=300),
})
public class ContentCategories {
    public static final String CONTENT = "content";
}
