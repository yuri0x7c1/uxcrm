package org.apache.ofbiz.content.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Analytics Config
 */
public class WebAnalyticsConfig implements Serializable {

	public static final long serialVersionUID = 1424704335208918016L;
	public static final String NAME = "WebAnalyticsConfig";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Web Analytics Type Id
	 */
	@Getter
	@Setter
	private String webAnalyticsTypeId;
	/**
	 * Web Analytics Code
	 */
	@Getter
	@Setter
	private String webAnalyticsCode;

	public enum Fields {
		webSiteId, webAnalyticsTypeId, webAnalyticsCode
	}

	public WebAnalyticsConfig(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		webAnalyticsTypeId = (String) value.get(Fields.webAnalyticsTypeId
				.name());
		webAnalyticsCode = (String) value.get(Fields.webAnalyticsCode.name());
	}

	public static WebAnalyticsConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebAnalyticsConfig(value);
	}

	public static List<WebAnalyticsConfig> fromValues(List<GenericValue> values) {
		List<WebAnalyticsConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebAnalyticsConfig(value));
		}
		return entities;
	}
}