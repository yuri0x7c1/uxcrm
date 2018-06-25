package com.github.yuri0x7c1.uxcrm.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.VaadinSecurity;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;
import org.vaadin.spring.sidebar.annotation.VaadinFontIcon;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.category.CommonCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;

@VaadinFontIcon(VaadinIcons.POWER_OFF)
@SideBarItem(sectionId = CommonCategories.OPERATIONS, caption = "Logout")
@SpringComponent
public class LogoutOperation implements Runnable {

    private final VaadinSecurity vaadinSecurity;

    @Autowired
    public LogoutOperation(VaadinSecurity vaadinSecurity) {
        this.vaadinSecurity = vaadinSecurity;
    }

    @Override
    public void run() {
        vaadinSecurity.logout();
    }
}