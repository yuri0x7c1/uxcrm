package com.github.yuri0x7c1.uxcrm.common.ui.topbar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.VaadinSecurity;
import org.vaadin.spring.sidebar.components.ValoSideBar;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritinv7.label.MLabel;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.ValoTheme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@UIScope
@SpringComponent
public class TopBar extends CssLayout {
	
	@Autowired
	VaadinSecurity vaadinSecurity;
	
	@Autowired
	ValoSideBar sideBar;
	
	MButton collapseButton = new MButton(VaadinIcons.MENU)
			.withStyleName(ValoTheme.BUTTON_LINK, "collapse-button");
	
	MButton logoutButton = new MButton(VaadinIcons.POWER_OFF)
			.withStyleName(ValoTheme.BUTTON_LINK, "logout-button");
	
	MLabel userLabel;
	
	public TopBar() {
		addStyleNames("uxcrm-topbar");
		addComponent(collapseButton);
		addComponent(logoutButton);
	}
	
	@PostConstruct
	public void init() {
		userLabel = new MLabel(vaadinSecurity.getAuthentication().getName())
			.withStyleName(ValoTheme.TEXTFIELD_ALIGN_RIGHT, "user-label");
		addComponent(userLabel);
		
		collapseButton.withListener(e -> {
			sideBar.setLargeIcons(!sideBar.isLargeIcons());
		});
		
		logoutButton.withListener(e -> vaadinSecurity.logout());
	}
}