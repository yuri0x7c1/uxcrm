package org.apache.ofbiz.common.uom;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom And Group
 */
@FieldNameConstants
public class UomAndGroup implements Serializable {

	public static final long serialVersionUID = 620400723604668416L;
	public static final String NAME = "UomAndGroup";
	/**
	 * Uom Group Id
	 */
	@Getter
	@Setter
	private String uomGroupId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Uom Type Id
	 */
	@Getter
	@Setter
	private String uomTypeId;
	/**
	 * Type Parent Type Id
	 */
	@Getter
	@Setter
	private String typeParentTypeId;
	/**
	 * Type Has Table
	 */
	@Getter
	@Setter
	private String typeHasTable;
	/**
	 * Type Description
	 */
	@Getter
	@Setter
	private String typeDescription;
	/**
	 * Type Uom Type Id
	 */
	@Getter
	@Setter
	private String typeUomTypeId;

	public UomAndGroup(GenericValue value) {
		uomGroupId = (String) value.get(FIELD_UOM_GROUP_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		uomTypeId = (String) value.get(FIELD_UOM_TYPE_ID);
		typeParentTypeId = (String) value.get(FIELD_TYPE_PARENT_TYPE_ID);
		typeHasTable = (String) value.get(FIELD_TYPE_HAS_TABLE);
		typeDescription = (String) value.get(FIELD_TYPE_DESCRIPTION);
		typeUomTypeId = (String) value.get(FIELD_TYPE_UOM_TYPE_ID);
	}

	public static UomAndGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UomAndGroup(value);
	}

	public static List<UomAndGroup> fromValues(List<GenericValue> values) {
		List<UomAndGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomAndGroup(value));
		}
		return entities;
	}
}