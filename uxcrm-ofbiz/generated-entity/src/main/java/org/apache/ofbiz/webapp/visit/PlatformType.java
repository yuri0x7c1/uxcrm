package org.apache.ofbiz.webapp.visit;

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
public class PlatformType implements Serializable {

	public static final long serialVersionUID = 7809241611351837696L;
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

	public enum Fields {
		platformTypeId, platformName, platformVersion, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PlatformType(GenericValue value) {
		platformTypeId = (String) value.get(Fields.platformTypeId.name());
		platformName = (String) value.get(Fields.platformName.name());
		platformVersion = (String) value.get(Fields.platformVersion.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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