package org.apache.ofbiz.common.method.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Custom Method Type
 */
public class CustomMethodType implements Serializable {

	public static final long serialVersionUID = 3026266190497344512L;
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

	public enum Fields {
		customMethodTypeId, parentTypeId, hasTable, description
	}

	public CustomMethodType(GenericValue value) {
		customMethodTypeId = (String) value.get(Fields.customMethodTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
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