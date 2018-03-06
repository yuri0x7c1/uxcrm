package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Group Role
 */
public class FacilityGroupRole implements Serializable {

	public static final long serialVersionUID = 3131666159654232064L;
	public static final String NAME = "FacilityGroupRole";
	/**
	 * Facility Group Id
	 */
	@Getter
	@Setter
	private String facilityGroupId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		facilityGroupId, partyId, roleTypeId
	}

	public FacilityGroupRole(GenericValue value) {
		facilityGroupId = (String) value.get(Fields.facilityGroupId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static FacilityGroupRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityGroupRole(value);
	}

	public static List<FacilityGroupRole> fromValues(List<GenericValue> values) {
		List<FacilityGroupRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityGroupRole(value));
		}
		return entities;
	}
}