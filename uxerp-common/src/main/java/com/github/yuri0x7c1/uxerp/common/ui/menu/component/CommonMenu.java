package com.github.yuri0x7c1.uxerp.common.ui.menu.component;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.i18n.I18N;
import org.vaadin.viritin.layouts.MCssLayout;

import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxerp.common.ui.menu.annotation.MenuItems;
import com.github.yuri0x7c1.uxerp.common.ui.menu.tree.MenuNode;
import com.github.yuri0x7c1.uxerp.common.ui.menu.tree.MenuTree;
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
			Component subtree = buildSubTree(node);
			if (subtree instanceof MenuSubMenu) {
				addLeftMenuSubMenu((MenuSubMenu) subtree);
			}
			else if(subtree instanceof MenuButton) {
				addLeftMenuButton((MenuButton) subtree);
			}
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

	private Component buildSubTree(MenuNode node) {
		// log.debug("Adding menu item for node [{}]", node);

		for (MenuNode n : node.getChildNodes()) {
			if (n.isCategory()) {
				MenuSubMenu subMenu = LeftMenuSubMenuBuilder.get()
					.setCaption(n.getCaption())
					.setIcon(n.getIcon())
					.build();

				Component c = buildSubTree(n);
				if (c instanceof MenuSubMenu) {
					subMenu.addLeftMenuSubMenu((MenuSubMenu) c);
				}
				else if(c instanceof MenuButton) {
					subMenu.addLeftMenuButton((MenuButton) c);
				}
				return subMenu;

			}
			else {
				SpringView springViewAnnotaion = n.getBeanType().getAnnotation(SpringView.class);
				MenuButton menuButton = LeftMenuButtonBuilder.get()
					.setCaption(n.getCaption())
					.setIcon(n.getIcon())
					.navigateTo(springViewAnnotaion.name())
					.build();
				return menuButton;
			}
		}

		return null;
	}
}
