package com.github.yuri0x7c1.uxerp.devtools.ui.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.devtools.ui.menu.category.DevtoolsCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@MenuItem(categoryId=DevtoolsCategories.DEVTOOLS, caption=ServiceView.NAME, icon=VaadinIcons.COG)
@SpringView(name = ServiceView.NAME)
public class ServiceView extends CommonView implements View {

	@Autowired
	private I18N i18n;

	public static final String NAME = "Services";

	@PostConstruct
    public void init() {
		setHeaderText(i18n.get(NAME));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
