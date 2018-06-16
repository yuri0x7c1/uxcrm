package com.github.yuri0x7c1.uxcrm.content.ui.menu.category;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItems;

@Component
@MenuItems({
    @MenuItem(id = ContentCategories.CONTENT, caption = "Content", category=true, order=300),
})
public class ContentCategories {
    public static final String CONTENT = "content";
}
