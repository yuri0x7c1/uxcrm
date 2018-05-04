package com.github.yuri0x7c1.uxerp.ui.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.ui.Categories;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@MenuItem(sectionId=Categories.COMMON, caption=HomeView.NAME)
@SpringView(name = HomeView.NAME)
public class HomeView extends CommonView implements View {

	@Autowired
	private I18N i18n;

	public static final String NAME = "Home";

	@PostConstruct
    public void init() {
		setHeaderText(i18n.get(NAME));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
