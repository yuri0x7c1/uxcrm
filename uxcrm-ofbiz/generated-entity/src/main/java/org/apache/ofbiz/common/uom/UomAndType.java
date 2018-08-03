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

	public static final long serialVersionUID = 6791274656298352640L;
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

	public enum Fields {
		description, uomId, abbreviation, uomTypeId, typeParentTypeId, typeHasTable, typeDescription, typeUomTypeId
	}

	public UomAndType(GenericValue value) {
		description = (String) value.get(Fields.description.name());
		uomId = (String) value.get(Fields.uomId.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
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