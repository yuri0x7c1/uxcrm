package org.apache.ofbiz.content.website;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Analytics Type
 */
public class WebAnalyticsType implements Serializable {

	public static final long serialVersionUID = 8041541331943239680L;
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
		webAnalyticsTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WebAnalyticsType(GenericValue value) {
		webAnalyticsTypeId = (String) value.get(Fields.webAnalyticsTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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