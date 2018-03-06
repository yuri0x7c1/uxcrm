package org.apache.ofbiz.common._enum.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Enumeration Type
 */
public class EnumerationType implements Serializable {

	public static final long serialVersionUID = 1001021439416723456L;
	public static final String NAME = "EnumerationType";
	/**
	 * Enum Type Id
	 */
	@Getter
	@Setter
	private String enumTypeId;
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
		enumTypeId, parentTypeId, hasTable, description
	}

	public EnumerationType(GenericValue value) {
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EnumerationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EnumerationType(value);
	}

	public static List<EnumerationType> fromValues(List<GenericValue> values) {
		List<EnumerationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EnumerationType(value));
		}
		return entities;
	}
}