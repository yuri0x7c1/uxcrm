package com.github.yuri0x7c1.uxerp.devtools.entity.ui.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.ofbiz.entity.model.ModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.vaadin.gridutil.cell.GridCellFilter;
import org.vaadin.spring.i18n.I18N;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.view.CommonView;
import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxerp.devtools.entity.generator.IEntityGenerator;
import com.github.yuri0x7c1.uxerp.devtools.generator.util.GeneratorUtil;
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
@MenuItem(parentId=DevtoolsCategories.DEVTOOLS, caption=EntityView.NAME, icon=VaadinIcons.DATABASE)
@SpringView(name = EntityView.NAME)
public class EntityView extends CommonView implements View {

	private static final String ENTITY_NAME_COL_ID = "entityName";
	private static final String ENTITY_DESCRIPTION_COL_ID = "description";

	@Autowired
	private Environment env;

	@Autowired
	private I18N i18n;

	@Autowired
	private ModelOfbiz ofbiz;

	@Autowired
	private GeneratorUtil generatorUtil;

	private Button generateAllButton = new Button("Generate all");

	private Grid<ModelEntity> entityGrid = new Grid<>();

	private GridCellFilter<ModelEntity> entityGridFilter;

	public static final String NAME = "Entities";

	public Map<String, IEntityGenerator> entityGenerators;

	public EntityView() {
		setHeight(100.0f, Unit.PERCENTAGE);

		addHeaderComponent(generateAllButton);

		entityGrid.setWidth(100.f, Unit.PERCENTAGE);
		entityGrid.setHeight(100.0f, Unit.PERCENTAGE);
		addComponent(entityGrid);
		setExpandRatio(entityGrid, 1.0f);
	}

	@PostConstruct
    public void init() throws Exception {
		setHeaderText(i18n.get(NAME));

		// get all entity generators
		entityGenerators = generatorUtil.getAllEntityGenerators();

		// generate all button
		generateAllButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
		generateAllButton.addClickListener(event -> {
			List<String> errorEntities = new ArrayList<>();
			log.info("Generating all entities");
			for (ModelEntity entity : ofbiz.getEntities().values()) {
				for (IEntityGenerator entityGenerator : entityGenerators.values()) {
					try {
						entityGenerator.generate(entity);
						String msg = String.format("Entity %s generated successfully to %s", entity.getEntityName(), env.getProperty("generator.destination_path"));
						log.info(msg);
					}
					catch (Exception e) {
						errorEntities.add(entity.getEntityName());
						String msg = String.format("Generate entity %s failed", entity.getEntityName());
						log.error(msg, e);
					}
				}
			}

			if (errorEntities.isEmpty()) {
				new Notification("Entities generated!",
						Notification.Type.HUMANIZED_MESSAGE)
						.show(Page.getCurrent());
			}
			else {
				new Notification("Entities generated with problems in:" + String.join(", ", errorEntities),
						Notification.Type.WARNING_MESSAGE)
						.show(Page.getCurrent());
			}
		});

		entityGrid.addColumn(ModelEntity::getEntityName)
			.setId(ENTITY_NAME_COL_ID)
			.setCaption("Entity Name");

		entityGrid.addColumn(entity -> entity.getDescription().equals("None") ? "" : entity.getDescription())
			.setId(ENTITY_DESCRIPTION_COL_ID)
			.setCaption("Description");

		for (String entityGeneratorName : entityGenerators.keySet()) {
			entityGrid.addColumn(entity -> entityGeneratorName,
				new ButtonRenderer<ModelEntity>(clickEvent -> {

					IEntityGenerator entityGenerator = entityGenerators.get(entityGeneratorName);

					ModelEntity entity = clickEvent.getItem();
					log.debug("Entity name : {}", entity.getEntityName());

					try {
						entityGenerator.generate(entity);
						String msg = String.format("Entity %s generated successfully to %s", entity.getEntityName(), env.getProperty("generator.destination_path"));
						log.info(msg);
						new Notification(msg,
							Notification.Type.HUMANIZED_MESSAGE)
							.show(Page.getCurrent());
					}
					catch (Exception e) {
						String msg = String.format("Generate entity %s failed", entity.getEntityName());
						log.error(msg, e);
						new Notification(msg,
						    Notification.Type.ERROR_MESSAGE)
						    .show(Page.getCurrent());
					}
			    }));
		}

		entityGrid.setItems(ofbiz.getEntities().values());

		// init filters
		entityGridFilter = new GridCellFilter<>(entityGrid, ModelEntity.class);
		entityGridFilter.setTextFilter(ENTITY_NAME_COL_ID, true, false);
		entityGridFilter.setTextFilter(ENTITY_DESCRIPTION_COL_ID, true, false);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
