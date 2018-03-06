package org.apache.ofbiz.content.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Analytics Type
 */
public class WebAnalyticsType implements Serializable {

	public static final long serialVersionUID = 8515082813082746880L;
	public static final String NAME = "WebAnalyticsType";
	/**
	 * Web Analytics Type Id
	 */
	@Getter
	@Setter
	private String webAnalyticsTypeId;
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
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		webAnalyticsTypeId, parentTypeId, hasTable, description
	}

	public WebAnalyticsType(GenericValue value) {
		webAnalyticsTypeId = (String) value.get(Fields.webAnalyticsTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WebAnalyticsType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebAnalyticsType(value);
	}

	public static List<WebAnalyticsType> fromValues(List<GenericValue> values) {
		List<WebAnalyticsType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebAnalyticsType(value));
		}
		return entities;
	}
}