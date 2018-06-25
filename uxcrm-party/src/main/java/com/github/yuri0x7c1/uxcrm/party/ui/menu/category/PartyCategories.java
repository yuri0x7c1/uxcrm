package com.github.yuri0x7c1.uxcrm.party.ui.menu.category;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
    @SideBarSection(id = PartyCategories.PARTY, caption = "Party", order=200),
})
public class PartyCategories {
    public static final String PARTY = "party";
}
