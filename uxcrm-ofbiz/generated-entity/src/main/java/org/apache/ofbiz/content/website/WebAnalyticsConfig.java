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
 * Web Analytics Config
 */
@FieldNameConstants
public class WebAnalyticsConfig implements Serializable {

	public static final long serialVersionUID = 672119728579091456L;
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

	public WebAnalyticsConfig(GenericValue value) {
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		webAnalyticsTypeId = (String) value.get(FIELD_WEB_ANALYTICS_TYPE_ID);
		webAnalyticsCode = (String) value.get(FIELD_WEB_ANALYTICS_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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