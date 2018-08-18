package com.github.yuri0x7c1.uxcrm.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.VaadinSecurity;

import com.vaadin.spring.annotation.SpringComponent;

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