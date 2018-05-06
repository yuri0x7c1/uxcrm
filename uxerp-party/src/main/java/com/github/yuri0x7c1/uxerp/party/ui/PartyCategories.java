package com.github.yuri0x7c1.uxerp.party.ui;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategories;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategory;

@Component
@MenuCategories({
    @MenuCategory(id = PartyCategories.PARTY, caption = "Party"),
})
public class PartyCategories {
    public static final String PARTY = "party";
}
