package com.github.yuri0x7c1.uxcrm.common.ui.menu.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.layouts.MCssLayout;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItems;
import com.github.yuri0x7c1.uxcrm.common.ui.menu.tree.MenuNode;
import com.github.yuri0x7c1.uxcrm.common.ui.menu.tree.MenuTree;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.builder.left.LeftMenuButtonBuilder;
import kaesdingeling.hybridmenu.builder.left.LeftMenuSubMenuBuilder;
import kaesdingeling.hybridmenu.data.DesignItem;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.enums.EMenuComponents;
import kaesdingeling.hybridmenu.data.leftmenu.MenuButton;
import kaesdingeling.hybridmenu.data.leftmenu.MenuSubMenu;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringComponent
@UIScope
public class CommonMenu extends HybridMenu {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private I18N i18n;

	private MenuTree tree = new MenuTree();

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
		createMenuTree();

		log.debug("tree:\n{}", tree);

		for (MenuNode node : tree.getNodes()) {
			buildSubTree(node, this);
		}

	}

	private void createMenuTree() {
		log.debug("Scanning for menu items");

		String[] beanNames = applicationContext.getBeanNamesForAnnotation(MenuItems.class);
		for (String beanName : beanNames) {
			log.debug("Bean [{}] declares a menu items", beanName);
			for (MenuItem menuItemAnnotation : applicationContext.findAnnotationOnBean(beanName, MenuItems.class).value()) {
				log.debug("!!! menuItemAnnotation: {}", menuItemAnnotation);
				tree.addNode(new MenuNode(menuItemAnnotation));
			}
		}

		beanNames = applicationContext.getBeanNamesForAnnotation(MenuItem.class);
		for (String beanName : beanNames) {
			log.debug("Bean [{}] declares a menu item", beanName);
			Class<?> beanType = applicationContext.getType(beanName);
			MenuItem menuItemAnnotation = beanType.getAnnotation(MenuItem.class);
			tree.addNode(new MenuNode(menuItemAnnotation, beanType));
		}
	}

	private void buildSubTree(MenuNode node, Component parentComponent) {
		if (node.isCategory()) {
			MenuSubMenu subMenu = LeftMenuSubMenuBuilder.get()
				.setCaption(node.getCaption())
				.setIcon(node.getIcon())
				.build();

			if (parentComponent instanceof HybridMenu) {
				((HybridMenu) parentComponent).addLeftMenuSubMenu(subMenu);
			}
			else if (parentComponent instanceof MenuSubMenu) {
				((MenuSubMenu) parentComponent).addLeftMenuSubMenu(subMenu);
			}

			for (MenuNode n : node.getChildNodes()) {
				buildSubTree(n, subMenu);
			}
		}
		else {
			SpringView springViewAnnotaion = node.getBeanType().getAnnotation(SpringView.class);
			MenuButton menuButton = LeftMenuButtonBuilder.get()
				.setCaption(node.getCaption())
				.setIcon(node.getIcon())
				.navigateTo(springViewAnnotaion.name())
				.build();

			if (parentComponent instanceof HybridMenu) {
				((HybridMenu) parentComponent).addLeftMenuButton(menuButton);
			}
			else if (parentComponent instanceof MenuSubMenu) {
				((MenuSubMenu) parentComponent).addLeftMenuButton(menuButton);
			}
		}
	}
}
