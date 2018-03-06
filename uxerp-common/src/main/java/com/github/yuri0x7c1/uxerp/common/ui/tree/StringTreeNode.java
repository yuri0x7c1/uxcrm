package com.github.yuri0x7c1.uxerp.common.ui.tree;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class StringTreeNode {
	@Getter
	@Setter
	@NonNull
	private String name;

	@Override
	public String toString() {
		return name;
	}
}