package com.github.yuri0x7c1.uxerp.devtools.ui.menu.category;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItems;

@Component
@MenuItems({
    @MenuItem(id = DevtoolsCategories.DEVTOOLS, caption = "Devtools", category = true),
})
public class DevtoolsCategories {
	public static final String DEVTOOLS = "devtools";
}