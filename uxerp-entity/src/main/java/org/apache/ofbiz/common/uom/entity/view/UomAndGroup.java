package org.apache.ofbiz.common.uom.entity.view;

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

	public static final long serialVersionUID = 81373136204698624L;
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
		uomGroupId, uomId, uomTypeId, abbreviation, description, parentTypeId, hasTable
	}

	public UomAndGroup(GenericValue value) {
		uomGroupId = (String) value.get(Fields.uomGroupId.name());
		uomId = (String) value.get(Fields.uomId.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		description = (String) value.get(Fields.description.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
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