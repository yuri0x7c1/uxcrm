package org.apache.ofbiz.common.uom;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom And Type
 */
@FieldNameConstants
public class UomAndType implements Serializable {

	public static final long serialVersionUID = 2654394962220206080L;
	public static final String NAME = "UomAndType";
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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

	public UomAndType(GenericValue value) {
		description = (String) value.get(FIELD_DESCRIPTION);
		uomId = (String) value.get(FIELD_UOM_ID);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		uomTypeId = (String) value.get(FIELD_UOM_TYPE_ID);
		typeParentTypeId = (String) value.get(FIELD_TYPE_PARENT_TYPE_ID);
		typeHasTable = (String) value.get(FIELD_TYPE_HAS_TABLE);
		typeDescription = (String) value.get(FIELD_TYPE_DESCRIPTION);
		typeUomTypeId = (String) value.get(FIELD_TYPE_UOM_TYPE_ID);
	}

	public static UomAndType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UomAndType(value);
	}

	public static List<UomAndType> fromValues(List<GenericValue> values) {
		List<UomAndType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomAndType(value));
		}
		return entities;
	}
}