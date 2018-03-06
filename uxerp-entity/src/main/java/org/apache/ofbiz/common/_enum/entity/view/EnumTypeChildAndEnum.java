package org.apache.ofbiz.common._enum.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Enum Type Child And Enum
 */
public class EnumTypeChildAndEnum implements Serializable {

	public static final long serialVersionUID = 3785983603457377280L;
	public static final String NAME = "EnumTypeChildAndEnum";
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
	/**
	 * Enum Id
	 */
	@Getter
	@Setter
	private String enumId;
	/**
	 * Enum Code
	 */
	@Getter
	@Setter
	private String enumCode;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;

	public enum Fields {
		enumTypeId, parentTypeId, hasTable, description, enumId, enumCode, sequenceId
	}

	public EnumTypeChildAndEnum(GenericValue value) {
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		enumId = (String) value.get(Fields.enumId.name());
		enumCode = (String) value.get(Fields.enumCode.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
	}

	public static EnumTypeChildAndEnum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EnumTypeChildAndEnum(value);
	}

	public static List<EnumTypeChildAndEnum> fromValues(
			List<GenericValue> values) {
		List<EnumTypeChildAndEnum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EnumTypeChildAndEnum(value));
		}
		return entities;
	}
}