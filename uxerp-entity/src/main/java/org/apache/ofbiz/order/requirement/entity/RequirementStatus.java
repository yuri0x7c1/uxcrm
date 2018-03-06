package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Status
 */
public class RequirementStatus implements Serializable {

	public static final long serialVersionUID = 8276871337726494720L;
	public static final String NAME = "RequirementStatus";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;

	public enum Fields {
		requirementId, statusId, statusDate, changeByUserLoginId
	}

	public RequirementStatus(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
	}

	public static RequirementStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementStatus(value);
	}

	public static List<RequirementStatus> fromValues(List<GenericValue> values) {
		List<RequirementStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementStatus(value));
		}
		return entities;
	}
}