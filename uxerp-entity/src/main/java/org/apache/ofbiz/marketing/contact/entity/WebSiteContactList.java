package org.apache.ofbiz.marketing.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Contact List
 */
public class WebSiteContactList implements Serializable {

	public static final long serialVersionUID = 5636089460188876800L;
	public static final String NAME = "WebSiteContactList";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
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
		webSiteId, contactListId, fromDate, thruDate
	}

	public WebSiteContactList(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		contactListId = (String) value.get(Fields.contactListId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static WebSiteContactList fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSiteContactList(value);
	}

	public static List<WebSiteContactList> fromValues(List<GenericValue> values) {
		List<WebSiteContactList> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSiteContactList(value));
		}
		return entities;
	}
}