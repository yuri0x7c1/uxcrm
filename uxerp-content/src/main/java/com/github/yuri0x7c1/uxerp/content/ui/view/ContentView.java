package com.github.yuri0x7c1.uxerp.content.ui.view;

import javax.annotation.PostConstruct;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.content.ui.menu.category.ContentCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(parentId = ContentCategories.CONTENT, caption=ContentView.NAME, icon=VaadinIcons.BOOK, order = 1)
@UIScope
@SpringView(name =  ContentView.NAME)
public class ContentView extends CommonView implements View {

	public static final String NAME = "Content";

	public ContentView() {
		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);
	}

	@PostConstruct
    public void init() throws Exception {
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
