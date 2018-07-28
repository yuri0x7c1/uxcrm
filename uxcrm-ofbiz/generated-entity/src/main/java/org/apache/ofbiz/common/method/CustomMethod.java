package org.apache.ofbiz.common.method;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Method
 */
public class CustomMethod implements Serializable {

	public static final long serialVersionUID = 4785485136539304960L;
	public static final String NAME = "CustomMethod";
	/**
	 * Custom Method Id
	 */
	@Getter
	@Setter
	private String customMethodId;
	/**
	 * Custom Method Type Id
	 */
	@Getter
	@Setter
	private String customMethodTypeId;
	/**
	 * Custom Method Name
	 */
	@Getter
	@Setter
	private String customMethodName;
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
		customMethodId, customMethodTypeId, customMethodName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustomMethod(GenericValue value) {
		customMethodId = (String) value.get(Fields.customMethodId.name());
		customMethodTypeId = (String) value.get(Fields.customMethodTypeId
				.name());
		customMethodName = (String) value.get(Fields.customMethodName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CustomMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomMethod(value);
	}

	public static List<CustomMethod> fromValues(List<GenericValue> values) {
		List<CustomMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomMethod(value));
		}
		return entities;
	}
}