package com.github.yuri0x7c1.uxerp.devtools.ui.menu.category;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategories;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategory;

@Component
@MenuCategories({
    @MenuCategory(id = DevtoolsCategories.DEVTOOLS, caption = "Devtools"),
})
public class DevtoolsCategories {
	public static final String DEVTOOLS = "devtools";
}