package org.apache.ofbiz.webapp.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Page
 */
public class WebPage implements Serializable {

	public static final long serialVersionUID = 5217422681956040704L;
	public static final String NAME = "WebPage";
	/**
	 * Web Page Id
	 */
	@Getter
	@Setter
	private String webPageId;
	/**
	 * Page Name
	 */
	@Getter
	@Setter
	private String pageName;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;

	public enum Fields {
		webPageId, pageName, webSiteId
	}

	public WebPage(GenericValue value) {
		webPageId = (String) value.get(Fields.webPageId.name());
		pageName = (String) value.get(Fields.pageName.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
	}

	public static WebPage fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new WebPage(value);
	}

	public static List<WebPage> fromValues(List<GenericValue> values) {
		List<WebPage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebPage(value));
		}
		return entities;
	}
}