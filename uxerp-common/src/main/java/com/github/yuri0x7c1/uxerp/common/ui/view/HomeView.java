package com.github.yuri0x7c1.uxerp.common.ui.view;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = HomeView.NAME)
public class HomeView extends CommonView implements View {
	
	public static final String NAME = "Home";

	@PostConstruct
    public void init() {
		setHeaderText(NAME);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
