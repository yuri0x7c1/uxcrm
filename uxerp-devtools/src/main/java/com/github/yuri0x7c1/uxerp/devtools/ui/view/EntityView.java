package com.github.yuri0x7c1.uxerp.devtools.ui.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.label.MLabel;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
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
	private Delegator delegator;

	private MGrid<ModelEntity> entityGrid = new MGrid<>(ModelEntity.class)
			.withProperties("entityName")
			.withFullSize();

	public static final String NAME = "Entities";

	@PostConstruct
    public void init() throws Exception {
		setHeaderText(i18n.get(NAME));

		MLabel entityLabel = new MLabel();

		ModelReader modelReader = delegator.getModelReader();

		Set<String> entityNames = modelReader.getEntityNames();
		List<ModelEntity> entities = new ArrayList<>();
		for (String entityName : entityNames) {
			entities.add(modelReader.getModelEntity(entityName));
		}

		entityGrid.setItems(entities);

		addComponent(entityGrid);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
