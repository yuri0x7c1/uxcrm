package org.apache.ofbiz.content.website.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Content
 */
public class WebSiteContent implements Serializable {

	public static final long serialVersionUID = 5152378700277244928L;
	public static final String NAME = "WebSiteContent";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Web Site Content Type Id
	 */
	@Getter
	@Setter
	private String webSiteContentTypeId;
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

	public enum Fields {
		webSiteId, contentId, webSiteContentTypeId, fromDate, thruDate
	}

	public WebSiteContent(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		contentId = (String) value.get(Fields.contentId.name());
		webSiteContentTypeId = (String) value.get(Fields.webSiteContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static WebSiteContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSiteContent(value);
	}

	public static List<WebSiteContent> fromValues(List<GenericValue> values) {
		List<WebSiteContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSiteContent(value));
		}
		return entities;
	}
}