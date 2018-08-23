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
 * Web Site Content Type
 */
@FieldNameConstants
public class WebSiteContentType implements Serializable {

	public static final long serialVersionUID = 8952944154567306240L;
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

	public WebSiteContentType(GenericValue value) {
		webSiteContentTypeId = (String) value
				.get(FIELD_WEB_SITE_CONTENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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