package com.github.yuri0x7c1.uxerp.common.ui.menu.tree;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.yuri0x7c1.uxerp.common.ui.menu.category.CommonCategories;

import edu.emory.mathcs.backport.java.util.Collections;

public class MenuTree {
	List<MenuNode> nodes = new LinkedList<>();

	public List<MenuNode> getNodes() {
		return Collections.unmodifiableList(nodes);
	}

	public void addNode(MenuNode node) {
		if (CommonCategories.ROOT.equals(node.getParentId())) {
			nodes.add(node);
		}
		else {
			for (MenuNode n : nodes) {
				n.addNode(node);
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
