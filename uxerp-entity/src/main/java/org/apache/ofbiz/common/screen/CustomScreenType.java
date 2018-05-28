package org.apache.ofbiz.common.screen;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Screen Type
 */
public class CustomScreenType implements Serializable {

	public static final long serialVersionUID = 8920235515868509184L;
	public static final String NAME = "CustomScreenType";
	/**
	 * Custom Screen Type Id
	 */
	@Getter
	@Setter
	private String customScreenTypeId;
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
		customScreenTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustomScreenType(GenericValue value) {
		customScreenTypeId = (String) value.get(Fields.customScreenTypeId
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

	public static CustomScreenType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustomScreenType(value);
	}

	public static List<CustomScreenType> fromValues(List<GenericValue> values) {
		List<CustomScreenType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustomScreenType(value));
		}
		return entities;
	}
}