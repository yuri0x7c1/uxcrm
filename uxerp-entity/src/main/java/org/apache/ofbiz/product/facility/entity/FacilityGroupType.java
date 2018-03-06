package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Group Type
 */
public class FacilityGroupType implements Serializable {

	public static final long serialVersionUID = 6919260768046945280L;
	public static final String NAME = "FacilityGroupType";
	/**
	 * Facility Group Type Id
	 */
	@Getter
	@Setter
	private String facilityGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		facilityGroupTypeId, description
	}

	public FacilityGroupType(GenericValue value) {
		facilityGroupTypeId = (String) value.get(Fields.facilityGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FacilityGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupType(value);
	}

	public static List<FacilityGroupType> fromValues(List<GenericValue> values) {
		List<FacilityGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupType(value));
		}
		return entities;
	}
}