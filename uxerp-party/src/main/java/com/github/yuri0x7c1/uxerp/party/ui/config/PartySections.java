package com.github.yuri0x7c1.uxerp.party.ui.config;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;

@Component
@SideBarSection(id = PartySections.PARTY, captionCode = "Party", order = 1)
public class PartySections {
    public static final String PARTY = "Party";
}