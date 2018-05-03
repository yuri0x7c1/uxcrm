package com.github.yuri0x7c1.uxerp.ui;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
    @SideBarSection(id = Sections.COMMON, captionCode = "Common"),
})
public class Sections {
    public static final String COMMON = "common";
}