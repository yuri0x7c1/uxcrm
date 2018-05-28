package org.apache.ofbiz.common.method;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Method Type
 */
public class CustomMethodType implements Serializable {

	public static final long serialVersionUID = 3029298792199772160L;
	public static final String NAME = "CustomMethodType";
	/**
	 * Custom Method Type Id
	 */
	@Getter
	@Setter
	private String customMethodTypeId;
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
		customMethodTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustomMethodType(GenericValue value) {
		customMethodTypeId = (String) value.get(Fields.customMethodTypeId
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

	public static CustomMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomMethodType(value);
	}

	public static List<CustomMethodType> fromValues(List<GenericValue> values) {
		List<CustomMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomMethodType(value));
		}
		return entities;
	}
}