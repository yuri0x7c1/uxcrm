package com.github.yuri0x7c1.uxerp.ui.view;

import javax.annotation.PostConstruct;

import org.vaadin.spring.sidebar.annotation.SideBarItem;

import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.ui.Sections;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@SideBarItem(sectionId=Sections.COMMON, captionCode=HomeView.NAME)
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
