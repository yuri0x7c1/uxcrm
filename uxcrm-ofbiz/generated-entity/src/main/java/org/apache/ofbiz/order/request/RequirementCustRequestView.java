package org.apache.ofbiz.order.request;

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
public class RequirementCustRequestView implements Serializable {

	public static final long serialVersionUID = 6254711904169017344L;
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

	public enum Fields {
		custRequestId, custRequestItemSeqId, requirementId, requirementTypeId, description, productId, estimatedBudget, quantity, requirementStartDate, requiredByDate, statusId, priority, maximumAmount
	}

	public RequirementCustRequestView(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		description = (String) value.get(Fields.description.name());
		productId = (String) value.get(Fields.productId.name());
		estimatedBudget = (BigDecimal) value.get(Fields.estimatedBudget.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		requirementStartDate = (Timestamp) value
				.get(Fields.requirementStartDate.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		priority = (Long) value.get(Fields.priority.name());
		maximumAmount = (BigDecimal) value.get(Fields.maximumAmount.name());
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