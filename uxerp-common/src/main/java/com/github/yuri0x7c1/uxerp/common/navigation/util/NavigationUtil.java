package com.github.yuri0x7c1.uxerp.common.navigation.util;

import com.vaadin.ui.JavaScript;

public class NavigationUtil {
	/*
	 * Navigate back
	 */
	public static void back() {
		JavaScript.getCurrent().execute("history.back()");
	}
}
