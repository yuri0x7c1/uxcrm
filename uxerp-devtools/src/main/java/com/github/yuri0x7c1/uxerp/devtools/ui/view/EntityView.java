package com.github.yuri0x7c1.uxerp.devtools.ui.view;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.entity.model.ModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.gridutil.cell.GridCellFilter;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.label.MLabel;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxerp.devtools.ui.menu.category.DevtoolsCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@MenuItem(categoryId=DevtoolsCategories.DEVTOOLS, caption=EntityView.NAME, icon=VaadinIcons.DATABASE)
@SpringView(name = EntityView.NAME)
public class EntityView extends CommonView implements View {

	@Autowired
	private I18N i18n;

	@Autowired
	private ModelOfbiz ofbiz;

	private MGrid<ModelEntity> entityGrid = new MGrid<>(ModelEntity.class)
			.withProperties("entityName", "description")
			.withFullSize();

	private GridCellFilter<ModelEntity> entityGridFilter;

	public static final String NAME = "Entities";

	public EntityView() {
		setHeight(100.0f, Unit.PERCENTAGE);
		entityGrid.setHeight(100.0f, Unit.PERCENTAGE);
		addComponent(entityGrid);
		setExpandRatio(entityGrid, 1.0f);
	}

	@PostConstruct
    public void init() throws Exception {
		setHeaderText(i18n.get(NAME));

		MLabel entityLabel = new MLabel();

		entityGrid.setItems(ofbiz.getEntities().values());

		// init filters
		entityGridFilter = new GridCellFilter<>(entityGrid, ModelEntity.class);
		entityGridFilter.setTextFilter("entityName", true, false);
		entityGridFilter.setTextFilter("description", true, false);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
