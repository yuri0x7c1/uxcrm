package com.github.yuri0x7c1.uxerp.ui;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.spring.sidebar.SideBarItemDescriptor;
import org.vaadin.spring.sidebar.SideBarSectionDescriptor;
import org.vaadin.spring.sidebar.SideBarUtils;

import com.github.appreciated.app.layout.behaviour.AppLayout;
import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.builder.AppLayoutConfiguration.NavigatorProducer;
import com.github.appreciated.app.layout.builder.design.AppBarDesign;
import com.github.appreciated.app.layout.builder.elements.SubmenuBuilder;
import com.github.yuri0x7c1.uxerp.common.ui.view.HomeView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
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

    @Autowired
    private SideBarUtils sideBarUtils;

	@Override
	protected void init(VaadinRequest request) {
        getPage().setTitle(i18n.get("Application.name"));
        setContent(createLayout());
	}


	private AppLayout createLayout() {
		// create spring based navigation produces
		NavigatorProducer navigatorProducer = components -> {
			navigator.init(UI.getCurrent(), components);
			navigator.addProvider(springViewProvider);
			navigator.navigateTo(HomeView.NAME);
			return navigator;
		};

		// create builder
		AppLayoutBuilder appLayoutBuilder = AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE_HYBRID_NO_APP_BAR)
				.withDesign(AppBarDesign.DEFAULT)
				.withNavigatorProducer(navigatorProducer)
				.add("Home", VaadinIcons.HOME, HomeView.class);

		// create sections and items
		for (SideBarSectionDescriptor sectionDescriptor : sideBarUtils.getSideBarSections(MainUI.class)) {
			SubmenuBuilder sectionBuilder = SubmenuBuilder.get(sectionDescriptor.getCaption(), VaadinIcons.PLUS);
			for(SideBarItemDescriptor itemDescriptor : sideBarUtils.getSideBarItems(sectionDescriptor)) {
				try {
					String viewBeanName = (String) FieldUtils.readField(itemDescriptor, "beanName", true);
					Class viewBeanType = applicationContext.getType(viewBeanName);
					sectionBuilder.add(itemDescriptor.getCaption(), itemDescriptor.getIcon(), viewBeanType);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			appLayoutBuilder.add(sectionBuilder.build());
		}

		return appLayoutBuilder.build();
	}
}
