package org.apache.ofbiz.common._enum;

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

	public static final long serialVersionUID = 1039253163966846976L;
	public static final String NAME = "EnumTypeChildAndEnum";
	/**
	 * Parent Enum Type Id
	 */
	@Getter
	@Setter
	private String parentEnumTypeId;
	/**
	 * Parent Parent Type Id
	 */
	@Getter
	@Setter
	private String parentParentTypeId;
	/**
	 * Parent Has Table
	 */
	@Getter
	@Setter
	private String parentHasTable;
	/**
	 * Parent Description
	 */
	@Getter
	@Setter
	private String parentDescription;
	/**
	 * Child Enum Type Id
	 */
	@Getter
	@Setter
	private String childEnumTypeId;
	/**
	 * Child Has Table
	 */
	@Getter
	@Setter
	private String childHasTable;
	/**
	 * Child Description
	 */
	@Getter
	@Setter
	private String childDescription;
	/**
	 * Enum Type Id
	 */
	@Getter
	@Setter
	private String enumTypeId;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;

	public enum Fields {
		parentEnumTypeId, parentParentTypeId, parentHasTable, parentDescription, childEnumTypeId, childHasTable, childDescription, enumTypeId, enumId, enumCode, description, sequenceId
	}

	public EnumTypeChildAndEnum(GenericValue value) {
		parentEnumTypeId = (String) value.get(Fields.parentEnumTypeId.name());
		parentParentTypeId = (String) value.get(Fields.parentParentTypeId
				.name());
		parentHasTable = (String) value.get(Fields.parentHasTable.name());
		parentDescription = (String) value.get(Fields.parentDescription.name());
		childEnumTypeId = (String) value.get(Fields.childEnumTypeId.name());
		childHasTable = (String) value.get(Fields.childHasTable.name());
		childDescription = (String) value.get(Fields.childDescription.name());
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		enumId = (String) value.get(Fields.enumId.name());
		enumCode = (String) value.get(Fields.enumCode.name());
		description = (String) value.get(Fields.description.name());
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