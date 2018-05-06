package com.github.yuri0x7c1.uxerp.common.ui.menu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.yuri0x7c1.uxerp.common.ui.menu.category.CommonCategories;
import com.vaadin.icons.VaadinIcons;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuCategory {
    String id();

    String parentCategoryId() default CommonCategories.ROOT;

    String caption() default "";

    boolean i18n() default true;

    VaadinIcons icon() default VaadinIcons.QUESTION;

    int order() default Integer.MAX_VALUE;
}
