package com.github.yuri0x7c1.uxerp.common.ui.menu.tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.yuri0x7c1.uxerp.common.ui.menu.category.CommonCategories;


public class MenuTree {
	List<MenuNode> nodes = new LinkedList<>();

	public static class OrderComparator implements Comparator<MenuNode> {
		@Override
		public int compare(MenuNode o1, MenuNode o2) {
			return Integer.valueOf(o1.getOrder()).compareTo(Integer.valueOf(o2.getOrder()));
		}
	}

	public List<MenuNode> getNodes() {
		return Collections.unmodifiableList(nodes);
	}

	public List<MenuNode> sortNodes() {
		nodes.sort(new OrderComparator());
		return Collections.unmodifiableList(nodes);
	}

	public void addNode(MenuNode node) {
		if (CommonCategories.ROOT.equals(node.getParentId())) {
			nodes.add(node);
			sortNodes();
		}
		else {
			for (MenuNode n : nodes) {
				n.addNode(node);
				n.sortChildNodes();
			}
		}
	}

	@Override
	public String toString() {
		String output = null;
		try {
			output = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this);
		}
		catch (Exception e) {}
		return output;
	}
}
