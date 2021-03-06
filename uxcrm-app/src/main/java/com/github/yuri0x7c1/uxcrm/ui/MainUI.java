package com.github.yuri0x7c1.uxcrm.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.spring.security.VaadinSecurity;
import org.vaadin.spring.security.util.SecurityExceptionUtils;
import org.vaadin.spring.sidebar.components.ValoSideBar;
import org.vaadin.spring.sidebar.security.VaadinSecurityItemFilter;

import com.github.yuri0x7c1.uxcrm.common.ui.topbar.TopBar;
import com.github.yuri0x7c1.uxcrm.common.ui.view.AccessDeniedView;
import com.github.yuri0x7c1.uxcrm.common.ui.view.ErrorView;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringUI
@Push(transport = Transport.WEBSOCKET)
@Widgetset("com.vaadin.v7.Vaadin7WidgetSet")
@Theme("mytheme")
public class MainUI extends UI {
	@Autowired
	I18N i18n;

    @Autowired
    VaadinSecurity vaadinSecurity;

    @Autowired
    SpringViewProvider springViewProvider;
    
    @Autowired
    SpringNavigator navigator;
    
    @Autowired
    TopBar topBar;

    @Autowired
    ValoSideBar sideBar;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle(i18n.get("Application.name"));

        // Let's register a custom error handler to make the 'access denied' messages a bit friendlier.
        setErrorHandler(new DefaultErrorHandler() {
            @Override
            public void error(com.vaadin.server.ErrorEvent event) {
                if (SecurityExceptionUtils.isAccessDeniedException(event.getThrowable())) {
                    Notification.show("Sorry, you don't have access to do that.");
                } else {
                    super.error(event);
                }
            }
        });
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(false);
        verticalLayout.setSpacing(false);
        verticalLayout.setWidth(100f, Unit.PERCENTAGE);
        verticalLayout.setHeight(100f, Unit.PERCENTAGE);
        
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();

        sideBar.addStyleName("uxcrm-sidebar");
        if (getPage().getBrowserWindowWidth() < 768) {
        	sideBar.setLargeIcons(true);
        }
        
        getPage().addBrowserWindowResizeListener(event -> {
        	if (event.getWidth() < 768) {
        		sideBar.setLargeIcons(true);
        	}
        	else {
        		sideBar.setLargeIcons(false);
        	}
		});
        
        horizontalLayout.addComponent(sideBar);

        // By adding a security item filter, only views that are accessible to the user will show up in the side bar.
        sideBar.setItemFilter(new VaadinSecurityItemFilter(vaadinSecurity));
        horizontalLayout.addComponent(sideBar);

        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("view-container");
        viewContainer.setSizeFull();
        horizontalLayout.addComponent(viewContainer);
        horizontalLayout.setExpandRatio(viewContainer, 1f);
        
        verticalLayout.addComponents(topBar, horizontalLayout);
        verticalLayout.setExpandRatio(horizontalLayout, 1f);
        
        // Without an AccessDeniedView, the view provider would act like the restricted views did not exist at all.
        springViewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        navigator.init(this, viewContainer);
        navigator.addProvider(springViewProvider);
        navigator.setErrorView(ErrorView.class);
        navigator.navigateTo(navigator.getState());

        setContent(verticalLayout);
	}
}
