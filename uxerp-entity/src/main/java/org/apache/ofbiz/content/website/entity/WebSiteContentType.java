package org.apache.ofbiz.content.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Content Type
 */
public class WebSiteContentType implements Serializable {

	public static final long serialVersionUID = 2555387133515185152L;
	public static final String NAME = "WebSiteContentType";
	/**
	 * Web Site Content Type Id
	 */
	@Getter
	@Setter
	private String webSiteContentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;

	public enum Fields {
		webSiteContentTypeId, description, parentTypeId, hasTable
	}

	public WebSiteContentType(GenericValue value) {
		webSiteContentTypeId = (String) value.get(Fields.webSiteContentTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
	}

	public static WebSiteContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSiteContentType(value);
	}

	public static List<WebSiteContentType> fromValues(List<GenericValue> values) {
		List<WebSiteContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSiteContentType(value));
		}
		return entities;
	}
}