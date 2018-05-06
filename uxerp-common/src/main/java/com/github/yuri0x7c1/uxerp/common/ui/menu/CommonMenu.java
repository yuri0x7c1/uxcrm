package com.github.yuri0x7c1.uxerp.common.ui.menu;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.layouts.MCssLayout;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.DesignItem;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.enums.EMenuComponents;
import kaesdingeling.hybridmenu.data.leftmenu.MenuButton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringComponent
@UIScope
public class CommonMenu extends HybridMenu {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private I18N i18n;

	public CommonMenu() {
		super();

		MCssLayout content = new MCssLayout().withFullHeight();
		MenuConfig config = new MenuConfig();
		config.setDesignItem(DesignItem.getWhiteBlueDesign());
		setContent(content);
		setMenuComponent(EMenuComponents.LEFT_WITH_TOP);
		setConfig(config);
		build();
	}

	@PostConstruct
	private void init() {
		scanForItems();
	}

	private void scanForItems() {
		log.debug("Scanning for menu items");
		String[] beanNames = applicationContext.getBeanNamesForAnnotation(MenuItem.class);
		for (String beanName : beanNames) {
			log.debug("Bean [{}] declares a menu item", beanName);
			Class<?> beanType = applicationContext.getType(beanName);
			if (Runnable.class.isAssignableFrom(beanType)) {
				log.debug("Adding menu item for action [{}]", beanType);
			} else if (View.class.isAssignableFrom(beanType) && beanType.isAnnotationPresent(SpringView.class)) {
				log.debug("Adding menu item for view [{}]", beanType);
				MenuItem menuItemAnnotation = beanType.getAnnotation(MenuItem.class);
				SpringView springViewAnnotaion = beanType.getAnnotation(SpringView.class);

				MenuButton menuButton = new MenuButton();
				menuButton.setCaption(i18n.get(menuItemAnnotation.caption()));
				log.debug("!!!! {}", menuItemAnnotation.caption());
				menuButton.navigateTo(springViewAnnotaion.name());
				menuButton.setIcon(menuItemAnnotation.icon());
				menuButton.build();

				addLeftMenuButton(menuButton);
			}
		}
	}

}
