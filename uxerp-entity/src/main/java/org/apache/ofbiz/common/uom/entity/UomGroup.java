package org.apache.ofbiz.common.uom.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom Group
 */
public class UomGroup implements Serializable {

	public static final long serialVersionUID = 8780287133893282816L;
	public static final String NAME = "UomGroup";
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

	public enum Fields {
		uomGroupId, uomId
	}

	public UomGroup(GenericValue value) {
		uomGroupId = (String) value.get(Fields.uomGroupId.name());
		uomId = (String) value.get(Fields.uomId.name());
	}

	public static UomGroup fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new UomGroup(value);
	}

	public static List<UomGroup> fromValues(List<GenericValue> values) {
		List<UomGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UomGroup(value));
		}
		return entities;
	}
}