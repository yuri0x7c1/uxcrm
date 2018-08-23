package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Platform Type
 */
@FieldNameConstants
public class PlatformType implements Serializable {

	public static final long serialVersionUID = 7256787056411825152L;
	public static final String NAME = "PlatformType";
	/**
	 * Platform Type Id
	 */
	@Getter
	@Setter
	private String platformTypeId;
	/**
	 * Platform Name
	 */
	@Getter
	@Setter
	private String platformName;
	/**
	 * Platform Version
	 */
	@Getter
	@Setter
	private String platformVersion;
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

	public PlatformType(GenericValue value) {
		platformTypeId = (String) value.get(FIELD_PLATFORM_TYPE_ID);
		platformName = (String) value.get(FIELD_PLATFORM_NAME);
		platformVersion = (String) value.get(FIELD_PLATFORM_VERSION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PlatformType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PlatformType(value);
	}

	public static List<PlatformType> fromValues(List<GenericValue> values) {
		List<PlatformType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PlatformType(value));
		}
		return entities;
	}
}