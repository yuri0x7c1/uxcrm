package com.github.yuri0x7c1.uxcrm.devtools.entity.ui.view;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelField;
import org.apache.ofbiz.entity.model.ModelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.button.MButton;

import com.github.yuri0x7c1.uxcrm.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxcrm.common.navigation.util.NavigationUtil;
import com.github.yuri0x7c1.uxcrm.common.ui.view.CommonView;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.themes.ValoTheme;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@UIScope
@SpringView(name = EntityDetailView.NAME)
public class EntityDetailView extends CommonView implements View {
	private static final long serialVersionUID = 719002900696360148L;

	public static final String NAME = "entity-detail";

	@Autowired
	private I18N i18n;

	@Autowired
	private ModelOfbiz ofbizInstance;

	private Grid<ModelField> fieldGrid;

	private Grid<ModelRelation> relationGrid;

	@PostConstruct
	public void init() {
		// back button
		addHeaderComponent(
			new MButton(VaadinIcons.ARROW_BACKWARD, i18n.get("Back"), (ClickListener) event -> NavigationUtil.back())
			.withStyleName(ValoTheme.BUTTON_PRIMARY)
		);

		// field grid
		fieldGrid = new Grid<>();
		fieldGrid.setWidth("100%");
		fieldGrid.setCaption(i18n.get("Fields"));
		fieldGrid.addColumn(ModelField::getName).setCaption(i18n.get("Field.name"));
		fieldGrid.addColumn(ModelField::getType).setCaption(i18n.get("Field.type"));
		fieldGrid.addColumn(ModelField::getDescription).setCaption(i18n.get("Description"));
		addComponent(fieldGrid);

		// relation grid
		relationGrid = new Grid<>();
		relationGrid.setWidth("100%");
		relationGrid.setCaption(i18n.get("Relations"));
		relationGrid.addColumn(ModelRelation::getRelEntityName).setCaption(i18n.get("Relation.name"));
		relationGrid.addColumn(ModelRelation::getFkName).setCaption(i18n.get("Relation.fkName"));
		relationGrid.addColumn(ModelRelation::getType).setCaption(i18n.get("Relation.type"));
		relationGrid.addColumn(ModelRelation::getDescription).setCaption(i18n.get("Description"));
		addComponent(relationGrid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// validate params
		if (event.getParameters() == null || event.getParameters().isEmpty()) {
			log.error("Parameters is empty");
			NavigationUtil.back();
		}

		String entityName = event.getParameters();
		ModelEntity entity = ofbizInstance.getEntities().get(entityName);

		fieldGrid.setItems(entity.getFieldsUnmodifiable());
		relationGrid.setItems(entity.getRelationsList(true, true, true));

		setHeaderText(entityName);
	}
}
