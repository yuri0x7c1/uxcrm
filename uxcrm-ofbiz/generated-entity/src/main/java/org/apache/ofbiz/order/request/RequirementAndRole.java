package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class RequirementAndRole implements Serializable {

	public static final long serialVersionUID = 5938600150769418240L;
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

	public RequirementAndRole(GenericValue value) {
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		requirementTypeId = (String) value.get(FIELD_REQUIREMENT_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		deliverableId = (String) value.get(FIELD_DELIVERABLE_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		requirementStartDate = (Timestamp) value
				.get(FIELD_REQUIREMENT_START_DATE);
		requiredByDate = (Timestamp) value.get(FIELD_REQUIRED_BY_DATE);
		estimatedBudget = (BigDecimal) value.get(FIELD_ESTIMATED_BUDGET);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		reason = (String) value.get(FIELD_REASON);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
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