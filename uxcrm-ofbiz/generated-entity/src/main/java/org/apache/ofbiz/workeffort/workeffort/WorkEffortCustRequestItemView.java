package org.apache.ofbiz.workeffort.workeffort;

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
 * Work Effort Cust Request Item View
 */
@FieldNameConstants
public class WorkEffortCustRequestItemView implements Serializable {

	public static final long serialVersionUID = 512704577925664768L;
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

	public WorkEffortCustRequestItemView(GenericValue value) {
		statusItemDescription = (String) value
				.get(FIELD_STATUS_ITEM_DESCRIPTION);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		custRequestResolutionId = (String) value
				.get(FIELD_CUST_REQUEST_RESOLUTION_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		reservLength = (BigDecimal) value.get(FIELD_RESERV_LENGTH);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		maximumAmount = (BigDecimal) value.get(FIELD_MAXIMUM_AMOUNT);
		requiredByDate = (Timestamp) value.get(FIELD_REQUIRED_BY_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		priority = (Long) value.get(FIELD_PRIORITY);
		statusId = (String) value.get(FIELD_STATUS_ID);
		reservStart = (Timestamp) value.get(FIELD_RESERV_START);
		configId = (String) value.get(FIELD_CONFIG_ID);
		selectedAmount = (BigDecimal) value.get(FIELD_SELECTED_AMOUNT);
		story = (String) value.get(FIELD_STORY);
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