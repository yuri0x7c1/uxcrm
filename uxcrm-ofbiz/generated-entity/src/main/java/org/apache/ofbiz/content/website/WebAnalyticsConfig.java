package org.apache.ofbiz.content.website;

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
public class WebAnalyticsConfig implements Serializable {

	public static final long serialVersionUID = 8934746477740265472L;
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

	public enum Fields {
		webSiteId, webAnalyticsTypeId, webAnalyticsCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WebAnalyticsConfig(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		webAnalyticsTypeId = (String) value.get(Fields.webAnalyticsTypeId
				.name());
		webAnalyticsCode = (String) value.get(Fields.webAnalyticsCode.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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