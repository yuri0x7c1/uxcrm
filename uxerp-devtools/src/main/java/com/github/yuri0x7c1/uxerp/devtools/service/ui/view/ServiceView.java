package com.github.yuri0x7c1.uxerp.devtools.service.ui.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.vaadin.gridutil.cell.GridCellFilter;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.fields.MCheckBox;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxerp.devtools.entity.ui.view.EntityDetailView;
import com.github.yuri0x7c1.uxerp.devtools.service.generator.ServiceGenerator;
import com.github.yuri0x7c1.uxerp.devtools.ui.menu.category.DevtoolsCategories;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.themes.ValoTheme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MenuItem(parentId=DevtoolsCategories.DEVTOOLS, caption=ServiceView.NAME, icon=VaadinIcons.COG)
@SpringView(name = ServiceView.NAME)
public class ServiceView extends CommonView implements View {

	private static final String SERVICE_NAME_COL_ID = "name";
	private static final String SERVICE_DESCRIPTION_COL_ID = "description";

	@Autowired
	Environment env;

	@Autowired
	private I18N i18n;

	@Autowired
	private ModelOfbiz ofbiz;

	@Resource
	private Map<String, ServiceGenerator> serviceGenerators;

	private Map<String, MCheckBox> availableGenerators = new HashMap<>();

	private Button generateAllButton = new Button("Generate all");

	private Grid<ModelService> serviceGrid = new Grid<>();

	private GridCellFilter<ModelService> serviceGridFilter;

	public static final String NAME = "Services";

	public ServiceView() {
		setHeight(100.0f, Unit.PERCENTAGE);

		addHeaderComponent(generateAllButton);

		serviceGrid.setWidth(100.f, Unit.PERCENTAGE);
		serviceGrid.setHeight(100.0f, Unit.PERCENTAGE);
		addComponent(serviceGrid);
		setExpandRatio(serviceGrid, 1.0f);
	}

	@PostConstruct
    public void init() {
		setHeaderText(i18n.get(NAME));

		// init available generators map
		for (String serviceGeneratorName : serviceGenerators.keySet()) {
			availableGenerators.put(serviceGeneratorName, new MCheckBox(serviceGeneratorName));
		}

		// generate all services button
		generateAllButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
		generateAllButton.addClickListener(event -> {
			List<String> errorEntities = new ArrayList<>();
			log.info("Generating all services");
			for (ModelService service : ofbiz.getServices().values()) {
				for (ServiceGenerator serviceGenerator : serviceGenerators.values()) {
					if (availableGenerators.get(serviceGenerator.getName()).getValue()) {
						try {
							serviceGenerator.generate(service);
							String msg = String.format("Service %s generated successfully to %s", service.name, env.getProperty("generator.destination_path"));
							log.info(msg);
						}
						catch (Exception e) {
							errorEntities.add(service.name);
							String msg = String.format("Generate service %s failed", service.name);
							log.error(msg, e);
						}
					}
				}
			}
		});

		// add view button column
		serviceGrid.addColumn(service -> "View",
			new ButtonRenderer<ModelService>(clickEvent -> {
				getUI().getNavigator().navigateTo(ServiceDetailView.NAME + "/" + clickEvent.getItem().name);
		    })
		);

		// add service name column
		serviceGrid.addColumn(service -> service.name)
			.setId(SERVICE_NAME_COL_ID)
			.setCaption("Name");

		// add service description column
		serviceGrid.addColumn(service -> service.description.equals("None") ? "" : service.description)
			.setId(SERVICE_DESCRIPTION_COL_ID)
			.setCaption("Description")
			.setWidth(200.0);

		// add button for every generator
		for (String serviceGeneratorName : serviceGenerators.keySet()) {
			serviceGrid.addColumn(entity -> serviceGeneratorName,
				new ButtonRenderer<ModelService>(clickEvent -> {
					ModelService service = clickEvent.getItem();
					log.debug("Service name : {}", service.name);

					try {
						serviceGenerators.get(serviceGeneratorName).generate(service);
						String msg = String.format("Service %s generated successfully to %s", service.name, env.getProperty("generator.destination_path"));
						log.info(msg);
						new Notification(msg,
							Notification.Type.HUMANIZED_MESSAGE)
							.show(Page.getCurrent());
					}
					catch (Exception e) {
						String msg = String.format("Generate service %s failed", service.name);
						log.error(msg, e);
						new Notification(msg,
						    Notification.Type.ERROR_MESSAGE)
						    .show(Page.getCurrent());
					}
			    })).setId(serviceGeneratorName);

			// add generator checkbox
			serviceGrid.getDefaultHeaderRow()
				.getCell(serviceGeneratorName)
				.setComponent(availableGenerators.get(serviceGeneratorName));
		}

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
