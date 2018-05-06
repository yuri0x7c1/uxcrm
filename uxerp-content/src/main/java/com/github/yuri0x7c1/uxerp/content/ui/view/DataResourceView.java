package com.github.yuri0x7c1.uxerp.content.ui.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.content.ui.component.DataResourceList;
import com.github.yuri0x7c1.uxerp.content.ui.config.CmsSections;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @VaadinFontIcon(VaadinIcons.EDIT)
@MenuItem(sectionId = CmsSections.CMS, caption=DataResourceView.NAME, order = 3)
@UIScope
@SpringView(name =  DataResourceView.NAME)
public class DataResourceView extends CommonView implements View {

	public static final String NAME = "DataResources";

	private final DataResourceList dataResourceGrid;


	@Autowired
	public DataResourceView(DataResourceList dataResourceList) {
		super();
		this.dataResourceGrid = dataResourceList;

		setHeaderText(NAME);
		setHeight(100, Unit.PERCENTAGE);

		addComponent(this.dataResourceGrid);
		setExpandRatio(this.dataResourceGrid, 1.0f);
	}

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
