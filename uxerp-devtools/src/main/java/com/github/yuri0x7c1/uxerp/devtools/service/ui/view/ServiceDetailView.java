package com.github.yuri0x7c1.uxerp.devtools.service.ui.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.service.ModelParam;
import org.apache.ofbiz.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.button.MButton;

import com.github.yuri0x7c1.uxerp.common.navigation.util.NavigationUtil;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxerp.devtools.service.util.ServiceUtil;
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
@SpringView(name = ServiceDetailView.NAME)
public class ServiceDetailView extends CommonView implements View {
	private static final long serialVersionUID = 719002900696360148L;

	public static final String NAME = "service-detail";

	@Autowired
	private I18N i18n;

	@Autowired
	private ModelOfbiz ofbizInstance;

	@Autowired
	private ServiceUtil serviceUtil;

	private Grid<ModelParam> parametersGrid;

	@PostConstruct
	public void init() {
		// back button
		addHeaderComponent(
			new MButton(VaadinIcons.ARROW_BACKWARD, i18n.get("Back"), (ClickListener) event -> NavigationUtil.back())
			.withStyleName(ValoTheme.BUTTON_PRIMARY)
		);

		// field grid
		parametersGrid = new Grid<>();
		parametersGrid.setWidth("100%");
		parametersGrid.setCaption(i18n.get("Parameters"));
		parametersGrid.addColumn(ModelParam::getName).setCaption(i18n.get("Parameter.name"));
		parametersGrid.addColumn(ModelParam::isOptional).setCaption(i18n.get("Parameter.optional"));
		parametersGrid.addColumn(ModelParam::getType).setCaption(i18n.get("Parameter.type"));
		parametersGrid.addColumn(ModelParam::getMode).setCaption(i18n.get("Parameter.mode"));
		parametersGrid.addColumn(ModelParam::getEntityName).setCaption(i18n.get("Parameter.entityName"));
		addComponent(parametersGrid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// validate params
		if (event.getParameters() == null || event.getParameters().isEmpty()) {
			log.error("Parameters is empty");
			NavigationUtil.back();
		}

		String serviceName = event.getParameters();
		ModelService service = ofbizInstance.getServices().get(serviceName);

		// TODO: move to separate method
		List<ModelParam> serviceParams = new ArrayList<>();
		for (String paramName : service.getAllParamNames()) {
			serviceParams.add(service.getParam(paramName));
		}
		parametersGrid.setItems(serviceParams);

		setHeaderText(serviceName);
	}
}
