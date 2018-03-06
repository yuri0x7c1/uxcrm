package org.apache.ofbiz.content.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Path Alias
 */
public class WebSitePathAlias implements Serializable {

	public static final long serialVersionUID = 3176985154622776320L;
	public static final String NAME = "WebSitePathAlias";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Path Alias
	 */
	@Getter
	@Setter
	private String pathAlias;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Alias To
	 */
	@Getter
	@Setter
	private String aliasTo;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Map Key
	 */
	@Getter
	@Setter
	private String mapKey;

	public enum Fields {
		webSiteId, pathAlias, fromDate, thruDate, aliasTo, contentId, mapKey
	}

	public WebSitePathAlias(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		pathAlias = (String) value.get(Fields.pathAlias.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		aliasTo = (String) value.get(Fields.aliasTo.name());
		contentId = (String) value.get(Fields.contentId.name());
		mapKey = (String) value.get(Fields.mapKey.name());
	}

	public static WebSitePathAlias fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSitePathAlias(value);
	}

	public static List<WebSitePathAlias> fromValues(List<GenericValue> values) {
		List<WebSitePathAlias> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSitePathAlias(value));
		}
		return entities;
	}
}