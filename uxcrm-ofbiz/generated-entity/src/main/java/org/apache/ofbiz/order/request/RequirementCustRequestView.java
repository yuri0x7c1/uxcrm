package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Cust Request View
 */
@FieldNameConstants
public class RequirementCustRequestView implements Serializable {

	public static final long serialVersionUID = 7917331380734151680L;
	public static final String NAME = "RequirementCustRequestView";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Maximum Amount
	 */
	@Getter
	@Setter
	private BigDecimal maximumAmount;

	public RequirementCustRequestView(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		requirementTypeId = (String) value.get(FIELD_REQUIREMENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		estimatedBudget = (BigDecimal) value.get(FIELD_ESTIMATED_BUDGET);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		requirementStartDate = (Timestamp) value
				.get(FIELD_REQUIREMENT_START_DATE);
		requiredByDate = (Timestamp) value.get(FIELD_REQUIRED_BY_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		priority = (Long) value.get(FIELD_PRIORITY);
		maximumAmount = (BigDecimal) value.get(FIELD_MAXIMUM_AMOUNT);
	}

	public static RequirementCustRequestView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementCustRequestView(value);
	}

	public static List<RequirementCustRequestView> fromValues(
			List<GenericValue> values) {
		List<RequirementCustRequestView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementCustRequestView(value));
		}
		return entities;
	}
}