package org.apache.ofbiz.common.uom;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom And Group
 */
public class UomAndGroup implements Serializable {

	public static final long serialVersionUID = 6702038485639445504L;
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
		uomGroupId, uomId, description, abbreviation, uomTypeId, numericCode, typeParentTypeId, typeHasTable, typeDescription, typeUomTypeId
	}

	public UomAndGroup(GenericValue value) {
		uomGroupId = (String) value.get(Fields.uomGroupId.name());
		uomId = (String) value.get(Fields.uomId.name());
		description = (String) value.get(Fields.description.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		numericCode = (Long) value.get(Fields.numericCode.name());
		typeParentTypeId = (String) value.get(Fields.typeParentTypeId.name());
		typeHasTable = (String) value.get(Fields.typeHasTable.name());
		typeDescription = (String) value.get(Fields.typeDescription.name());
		typeUomTypeId = (String) value.get(Fields.typeUomTypeId.name());
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