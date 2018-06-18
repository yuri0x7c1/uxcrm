package com.github.yuri0x7c1.uxcrm.content.data;

@FunctionalInterface
public interface WebSiteTreeFilter {
	boolean filter(String name);
}
