package org.apache.ofbiz.common.uom;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom And Type
 */
public class UomAndType implements Serializable {

	public static final long serialVersionUID = 1864080748531672064L;
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
	 * Numeric Code
	 */
	@Getter
	@Setter
	private Long numericCode;
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

	public enum Fields {
		description, uomId, abbreviation, uomTypeId, numericCode, typeParentTypeId, typeHasTable, typeDescription, typeUomTypeId
	}

	public UomAndType(GenericValue value) {
		description = (String) value.get(Fields.description.name());
		uomId = (String) value.get(Fields.uomId.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		numericCode = (Long) value.get(Fields.numericCode.name());
		typeParentTypeId = (String) value.get(Fields.typeParentTypeId.name());
		typeHasTable = (String) value.get(Fields.typeHasTable.name());
		typeDescription = (String) value.get(Fields.typeDescription.name());
		typeUomTypeId = (String) value.get(Fields.typeUomTypeId.name());
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