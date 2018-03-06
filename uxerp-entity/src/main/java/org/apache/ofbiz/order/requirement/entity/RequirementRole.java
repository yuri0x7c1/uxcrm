package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Role
 */
public class RequirementRole implements Serializable {

	public static final long serialVersionUID = 1331579000093043712L;
	public static final String NAME = "RequirementRole";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
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
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		requirementId, partyId, roleTypeId, fromDate, thruDate
	}

	public RequirementRole(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static RequirementRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementRole(value);
	}

	public static List<RequirementRole> fromValues(List<GenericValue> values) {
		List<RequirementRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementRole(value));
		}
		return entities;
	}
}