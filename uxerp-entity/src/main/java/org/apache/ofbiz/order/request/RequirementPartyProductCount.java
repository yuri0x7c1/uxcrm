package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Party Product Count
 */
public class RequirementPartyProductCount implements Serializable {

	public static final long serialVersionUID = 1577765565993929728L;
	public static final String NAME = "RequirementPartyProductCount";
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private Long productId;
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
		requirementTypeId, statusId, productId, partyId, roleTypeId, fromDate, thruDate
	}

	public RequirementPartyProductCount(GenericValue value) {
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		productId = (Long) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static RequirementPartyProductCount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementPartyProductCount(value);
	}

	public static List<RequirementPartyProductCount> fromValues(
			List<GenericValue> values) {
		List<RequirementPartyProductCount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementPartyProductCount(value));
		}
		return entities;
	}
}