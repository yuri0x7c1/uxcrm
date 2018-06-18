package com.github.yuri0x7c1.uxcrm.content.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class WebSiteTreeNode {
	public static final String TYPE_WEB_SITE = "WEB_SITE";
	public static final String TYPE_CONTENT = "CONTENT";

	@Getter
	@Setter
	private String type;

	@Getter
	@Setter
	private String webSiteId;

	@Getter
	@Setter
	private String webSiteName;

	@Getter
	@Setter
	private String contentId;

	@Getter
	@Setter
	private String contentName;

	@Getter
	@Setter
	private String contentTypeId;

	@Override
	public String toString() {
		if (TYPE_WEB_SITE.equals(type)) {
			return webSiteName + "[" + webSiteId + "]";
		}
		else if (TYPE_CONTENT.equals(type)) {
			return contentName + "[" + contentId + "]";
		}

		return "";
	}
}
