package com.github.yuri0x7c1.uxerp.party.ui.menu.category;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItems;

@Component
@MenuItems({
    @MenuItem(id = PartyCategories.PARTY, caption = "Party", category=true, order=200),
})
public class PartyCategories {
    public static final String PARTY = "party";
}
