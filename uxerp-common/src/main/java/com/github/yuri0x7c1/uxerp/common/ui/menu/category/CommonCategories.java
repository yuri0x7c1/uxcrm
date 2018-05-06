package com.github.yuri0x7c1.uxerp.common.ui.menu.category;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategories;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategory;

@Component
@MenuCategories({
    @MenuCategory(id = CommonCategories.COMMON, caption = "Common"),
})
public class CommonCategories {
	public static final String ROOT = "root";
    public static final String COMMON = "common";
}