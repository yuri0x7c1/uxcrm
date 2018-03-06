package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Type
 */
public class FacilityType implements Serializable {

	public static final long serialVersionUID = 6178570696476600320L;
	public static final String NAME = "FacilityType";
	/**
	 * Facility Type Id
	 */
	@Getter
	@Setter
	private String facilityTypeId;
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
		facilityTypeId, parentTypeId, hasTable, description
	}

	public FacilityType(GenericValue value) {
		facilityTypeId = (String) value.get(Fields.facilityTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FacilityType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityType(value);
	}

	public static List<FacilityType> fromValues(List<GenericValue> values) {
		List<FacilityType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityType(value));
		}
		return entities;
	}
}