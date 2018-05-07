package com.github.yuri0x7c1.uxerp.common.ui.search.component;

import com.github.yuri0x7c1.uxerp.common.find.util.FindUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SearchFieldOption {
	EQUALS(FindUtil.OPTION_EQUALS),
	CONTAINS(FindUtil.OPTION_CONTAINS);

	@Getter
	private String optionName;
}
