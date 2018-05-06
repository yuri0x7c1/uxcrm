package com.github.yuri0x7c1.uxerp.content.ui.config;

import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuCategory;

@Component
@MenuCategory(id = CmsSections.CMS, caption = "CMS", order = 3)
public class CmsSections {

    public static final String CMS = "CMS";
}
