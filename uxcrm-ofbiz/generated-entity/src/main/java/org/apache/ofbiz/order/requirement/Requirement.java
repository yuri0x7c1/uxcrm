package org.apache.ofbiz.order.requirement;

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
 * Requirement
 */
@FieldNameConstants
public class Requirement implements Serializable {

	public static final long serialVersionUID = 1140233423506338816L;
	public static final String NAME = "Requirement";
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Use Case
	 */
	@Getter
	@Setter
	private String useCase;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
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
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public Requirement(GenericValue value) {
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		requirementTypeId = (String) value.get(FIELD_REQUIREMENT_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		deliverableId = (String) value.get(FIELD_DELIVERABLE_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		requirementStartDate = (Timestamp) value
				.get(FIELD_REQUIREMENT_START_DATE);
		requiredByDate = (Timestamp) value.get(FIELD_REQUIRED_BY_DATE);
		estimatedBudget = (BigDecimal) value.get(FIELD_ESTIMATED_BUDGET);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		useCase = (String) value.get(FIELD_USE_CASE);
		reason = (String) value.get(FIELD_REASON);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Requirement fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Requirement(value);
	}

	public static List<Requirement> fromValues(List<GenericValue> values) {
		List<Requirement> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Requirement(value));
		}
		return entities;
	}
}