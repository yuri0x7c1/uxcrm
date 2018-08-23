package org.apache.ofbiz.common._enum;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Enum Type Child And Enum
 */
@FieldNameConstants
public class EnumTypeChildAndEnum implements Serializable {

	public static final long serialVersionUID = 9186267466099634176L;
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

	public EnumTypeChildAndEnum(GenericValue value) {
		parentEnumTypeId = (String) value.get(FIELD_PARENT_ENUM_TYPE_ID);
		parentParentTypeId = (String) value.get(FIELD_PARENT_PARENT_TYPE_ID);
		parentHasTable = (String) value.get(FIELD_PARENT_HAS_TABLE);
		parentDescription = (String) value.get(FIELD_PARENT_DESCRIPTION);
		childEnumTypeId = (String) value.get(FIELD_CHILD_ENUM_TYPE_ID);
		childHasTable = (String) value.get(FIELD_CHILD_HAS_TABLE);
		childDescription = (String) value.get(FIELD_CHILD_DESCRIPTION);
		enumTypeId = (String) value.get(FIELD_ENUM_TYPE_ID);
		enumId = (String) value.get(FIELD_ENUM_ID);
		enumCode = (String) value.get(FIELD_ENUM_CODE);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
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