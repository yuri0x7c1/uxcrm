package com.github.yuri0x7c1.uxerp.devtools.ui.view;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.gridutil.cell.GridCellFilter;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxerp.devtools.ui.menu.category.DevtoolsCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;

@MenuItem(categoryId=DevtoolsCategories.DEVTOOLS, caption=ServiceView.NAME, icon=VaadinIcons.COG)
@SpringView(name = ServiceView.NAME)
public class ServiceView extends CommonView implements View {

	private static final String SERVICE_NAME_COL_ID = "name";
	private static final String SERVICE_DESCRIPTION_COL_ID = "description";

	@Autowired
	private I18N i18n;

	@Autowired
	private ModelOfbiz ofbiz;

	private Grid<ModelService> serviceGrid = new Grid<>();

	private GridCellFilter<ModelService> serviceGridFilter;

	public static final String NAME = "Services";

	public ServiceView() {
		setHeight(100.0f, Unit.PERCENTAGE);
		serviceGrid.setWidth(100.f, Unit.PERCENTAGE);
		serviceGrid.setHeight(100.0f, Unit.PERCENTAGE);
		addComponent(serviceGrid);
		setExpandRatio(serviceGrid, 1.0f);
	}

	@PostConstruct
    public void init() {
		setHeaderText(i18n.get(NAME));

		serviceGrid.addColumn(service -> service.name)
			.setId(SERVICE_NAME_COL_ID)
			.setCaption("Name");

		serviceGrid.addColumn(service -> service.description.equals("None") ? "" : service.description)
			.setId(SERVICE_DESCRIPTION_COL_ID)
			.setCaption("Description");

		serviceGrid.setItems(ofbiz.getServices().values());

		// init filters
		serviceGridFilter = new GridCellFilter<>(serviceGrid, ModelService.class);
		serviceGridFilter.setTextFilter(SERVICE_NAME_COL_ID, true, false);
		serviceGridFilter.setTextFilter(SERVICE_DESCRIPTION_COL_ID, true, false);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
