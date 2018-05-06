package com.github.yuri0x7c1.uxerp.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxerp.common.ui.menu.component.CommonMenu;
import com.github.yuri0x7c1.uxerp.common.ui.view.ErrorView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringUI
@Widgetset("com.vaadin.v7.Vaadin7WidgetSet")
@Theme("mytheme")
public class MainUI extends UI {

	@Autowired
	ApplicationContext applicationContext;

    @Autowired
    SpringViewProvider springViewProvider;

    @Autowired
    SpringNavigator navigator;

    @Autowired
    I18N i18n;

	@Override
	protected void init(VaadinRequest request) {
        getPage().setTitle(i18n.get("Application.name"));
        setContent(createLayout());
	}


	private Component createLayout() {
		CommonMenu menu = applicationContext.getBean(CommonMenu.class);
		Navigator navigator = new Navigator(this, menu.getContent());

        navigator.addProvider(springViewProvider);
        navigator.setErrorView(ErrorView.class);
        navigator.navigateTo(navigator.getState());

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
	    layout.addComponent(menu);
	    return layout;
	}
}
