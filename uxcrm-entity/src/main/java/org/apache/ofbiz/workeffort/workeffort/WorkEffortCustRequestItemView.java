package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Cust Request Item View
 */
public class WorkEffortCustRequestItemView implements Serializable {

	public static final long serialVersionUID = 7917971835877189632L;
	public static final String NAME = "WorkEffortCustRequestItemView";
	/**
	 * Status Item Description
	 */
	@Getter
	@Setter
	private String statusItemDescription;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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
	 * Cust Request Resolution Id
	 */
	@Getter
	@Setter
	private String custRequestResolutionId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Reserv Length
	 */
	@Getter
	@Setter
	private BigDecimal reservLength;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Maximum Amount
	 */
	@Getter
	@Setter
	private BigDecimal maximumAmount;
	/**
	 * Required By Date
	 */
	@Getter
	@Setter
	private Timestamp requiredByDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Reserv Start
	 */
	@Getter
	@Setter
	private Timestamp reservStart;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Selected Amount
	 */
	@Getter
	@Setter
	private BigDecimal selectedAmount;
	/**
	 * Story
	 */
	@Getter
	@Setter
	private String story;

	public enum Fields {
		statusItemDescription, workEffortId, custRequestId, custRequestItemSeqId, custRequestResolutionId, quantity, reservLength, sequenceNum, productId, reservPersons, maximumAmount, requiredByDate, description, priority, statusId, reservStart, configId, selectedAmount, story
	}

	public WorkEffortCustRequestItemView(GenericValue value) {
		statusItemDescription = (String) value.get(Fields.statusItemDescription
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		custRequestResolutionId = (String) value
				.get(Fields.custRequestResolutionId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		reservLength = (BigDecimal) value.get(Fields.reservLength.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		productId = (String) value.get(Fields.productId.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		maximumAmount = (BigDecimal) value.get(Fields.maximumAmount.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		description = (String) value.get(Fields.description.name());
		priority = (Long) value.get(Fields.priority.name());
		statusId = (String) value.get(Fields.statusId.name());
		reservStart = (Timestamp) value.get(Fields.reservStart.name());
		configId = (String) value.get(Fields.configId.name());
		selectedAmount = (BigDecimal) value.get(Fields.selectedAmount.name());
		story = (String) value.get(Fields.story.name());
	}

	public static WorkEffortCustRequestItemView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortCustRequestItemView(value);
	}

	public static List<WorkEffortCustRequestItemView> fromValues(
			List<GenericValue> values) {
		List<WorkEffortCustRequestItemView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortCustRequestItemView(value));
		}
		return entities;
	}
}