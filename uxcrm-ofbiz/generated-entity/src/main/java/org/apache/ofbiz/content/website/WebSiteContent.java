package org.apache.ofbiz.content.website;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WebSiteContent implements Serializable {

	public static final long serialVersionUID = 1865495718890628096L;
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

	public WebSiteContent(GenericValue value) {
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		webSiteContentTypeId = (String) value
				.get(FIELD_WEB_SITE_CONTENT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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