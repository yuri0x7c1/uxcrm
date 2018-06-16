package com.github.yuri0x7c1.uxcrm.common.ui.menu.tree;

import java.util.LinkedList;
import java.util.List;

import com.github.yuri0x7c1.uxcrm.common.ui.menu.annotation.MenuItem;
import com.github.yuri0x7c1.uxcrm.common.ui.menu.tree.MenuTree.OrderComparator;
import com.vaadin.icons.VaadinIcons;

import edu.emory.mathcs.backport.java.util.Collections;
import lombok.Getter;

public class MenuNode {
	private MenuItem menuItemAnnotaion;

	@Getter
	private Class<?> beanType;

	public MenuNode(MenuItem menuItemAnnotaion) {
		this.menuItemAnnotaion = menuItemAnnotaion;
	}

	public MenuNode(MenuItem menuItemAnnotaion, Class<?> beanType) {
		this.menuItemAnnotaion = menuItemAnnotaion;
		this.beanType = beanType;
	}

	private List<MenuNode> childNodes = new LinkedList<>();

	public List<MenuNode> sortChildNodes() {
		childNodes.sort(new OrderComparator());
		return Collections.unmodifiableList(childNodes);
	}

	public List<MenuNode> getChildNodes() {
		return Collections.unmodifiableList(childNodes);
	}

	public String getId() {
		return menuItemAnnotaion.id();
	}

	public String getParentId() {
		return menuItemAnnotaion.parentId();
	}

	public String getCaption() {
		return menuItemAnnotaion.caption();
	}

	public boolean i18n() {
		return menuItemAnnotaion.i18n();
	}

	public VaadinIcons getIcon() {
		return menuItemAnnotaion.icon();
	}

	public int getOrder() {
		return menuItemAnnotaion.order();
	}

	public boolean isCategory() {
		return menuItemAnnotaion.category();
	}

	public void addNode(MenuNode node) {
		if (getId().equals(node.getParentId())) {
			childNodes.add(node);
			sortChildNodes();
		}
		else {
			for (MenuNode n : childNodes) {
				n.addNode(node);
				n.sortChildNodes();
			}
		}
	}
}
