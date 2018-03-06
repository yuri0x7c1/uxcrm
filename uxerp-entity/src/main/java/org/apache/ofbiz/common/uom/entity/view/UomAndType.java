package org.apache.ofbiz.common.uom.entity.view;

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

	public static final long serialVersionUID = 8375402672717661184L;
	public static final String NAME = "UomAndType";
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Uom Type Id
	 */
	@Getter
	@Setter
	private String uomTypeId;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public enum Fields {
		uomId, uomTypeId, abbreviation, description, parentTypeId, hasTable
	}

	public UomAndType(GenericValue value) {
		uomId = (String) value.get(Fields.uomId.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		description = (String) value.get(Fields.description.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
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