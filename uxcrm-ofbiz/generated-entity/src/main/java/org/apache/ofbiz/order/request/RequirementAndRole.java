package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement And Role
 */
public class RequirementAndRole implements Serializable {

	public static final long serialVersionUID = 5726998161038134272L;
	public static final String NAME = "RequirementAndRole";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
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
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Requirement Start Date
	 */
	@Getter
	@Setter
	private Timestamp requirementStartDate;
	/**
	 * Required By Date
	 */
	@Getter
	@Setter
	private Timestamp requiredByDate;
	/**
	 * Estimated Budget
	 */
	@Getter
	@Setter
	private BigDecimal estimatedBudget;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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
		requirementId, requirementTypeId, statusId, facilityId, deliverableId, fixedAssetId, productId, description, requirementStartDate, requiredByDate, estimatedBudget, quantity, reason, lastModifiedDate, lastModifiedByUserLogin, partyId, roleTypeId, fromDate, thruDate
	}

	public RequirementAndRole(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		deliverableId = (String) value.get(Fields.deliverableId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		productId = (String) value.get(Fields.productId.name());
		description = (String) value.get(Fields.description.name());
		requirementStartDate = (Timestamp) value
				.get(Fields.requirementStartDate.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		estimatedBudget = (BigDecimal) value.get(Fields.estimatedBudget.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		reason = (String) value.get(Fields.reason.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static RequirementAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementAndRole(value);
	}

	public static List<RequirementAndRole> fromValues(List<GenericValue> values) {
		List<RequirementAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementAndRole(value));
		}
		return entities;
	}
}