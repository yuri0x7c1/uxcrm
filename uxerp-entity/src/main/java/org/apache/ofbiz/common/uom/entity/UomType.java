package org.apache.ofbiz.common.uom.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom Type
 */
public class UomType implements Serializable {

	public static final long serialVersionUID = 3994000363264755712L;
	public static final String NAME = "UomType";
	/**
	 * Uom Type Id
	 */
	@Getter
	@Setter
	private String uomTypeId;
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
		uomTypeId, parentTypeId, hasTable, description
	}

	public UomType(GenericValue value) {
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static UomType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new UomType(value);
	}

	public static List<UomType> fromValues(List<GenericValue> values) {
		List<UomType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomType(value));
		}
		return entities;
	}
}