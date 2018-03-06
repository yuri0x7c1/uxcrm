package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Group
 */
public class FacilityGroup implements Serializable {

	public static final long serialVersionUID = 3964711165515480064L;
	public static final String NAME = "FacilityGroup";
	/**
	 * Facility Group Id
	 */
	@Getter
	@Setter
	private String facilityGroupId;
	/**
	 * Facility Group Type Id
	 */
	@Getter
	@Setter
	private String facilityGroupTypeId;
	/**
	 * Primary Parent Group Id
	 */
	@Getter
	@Setter
	private String primaryParentGroupId;
	/**
	 * Facility Group Name
	 */
	@Getter
	@Setter
	private String facilityGroupName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		facilityGroupId, facilityGroupTypeId, primaryParentGroupId, facilityGroupName, description
	}

	public FacilityGroup(GenericValue value) {
		facilityGroupId = (String) value.get(Fields.facilityGroupId.name());
		facilityGroupTypeId = (String) value.get(Fields.facilityGroupTypeId
				.name());
		primaryParentGroupId = (String) value.get(Fields.primaryParentGroupId
				.name());
		facilityGroupName = (String) value.get(Fields.facilityGroupName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FacilityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroup(value);
	}

	public static List<FacilityGroup> fromValues(List<GenericValue> values) {
		List<FacilityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroup(value));
		}
		return entities;
	}
}