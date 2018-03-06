package org.apache.ofbiz.common.status.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Status Type
 */
public class StatusType implements Serializable {

	public static final long serialVersionUID = 5797743354112242688L;
	public static final String NAME = "StatusType";
	/**
	 * Status Type Id
	 */
	@Getter
	@Setter
	private String statusTypeId;
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

	public enum Fields {
		statusTypeId, parentTypeId, hasTable, description
	}

	public StatusType(GenericValue value) {
		statusTypeId = (String) value.get(Fields.statusTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static StatusType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StatusType(value);
	}

	public static List<StatusType> fromValues(List<GenericValue> values) {
		List<StatusType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StatusType(value));
		}
		return entities;
	}
}