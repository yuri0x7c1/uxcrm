package com.github.yuri0x7c1.uxerp.common.ui.menu.category;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItems;

@Component
@MenuItems({
    @MenuItem(id = CommonCategories.COMMON, caption = "Common", category = true),
})
public class CommonCategories {
	public static final String ROOT = "root";
    public static final String COMMON = "common";
}