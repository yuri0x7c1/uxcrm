package org.apache.ofbiz.content.website;

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

	public static final long serialVersionUID = 6359953551218970624L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		webSiteId, contentId, webSiteContentTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WebSiteContent(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		contentId = (String) value.get(Fields.contentId.name());
		webSiteContentTypeId = (String) value.get(Fields.webSiteContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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