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
 * Cust Request Item
 */
@FieldNameConstants
public class CustRequestItem implements Serializable {

	public static final long serialVersionUID = 8050002928553911296L;
	public static final String NAME = "CustRequestItem";
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Required By Date
	 */
	@Getter
	@Setter
	private Timestamp requiredByDate;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Selected Amount
	 */
	@Getter
	@Setter
	private BigDecimal selectedAmount;
	/**
	 * Maximum Amount
	 */
	@Getter
	@Setter
	private BigDecimal maximumAmount;
	/**
	 * Reserv Start
	 */
	@Getter
	@Setter
	private Timestamp reservStart;
	/**
	 * Reserv Length
	 */
	@Getter
	@Setter
	private BigDecimal reservLength;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Story
	 */
	@Getter
	@Setter
	private String story;
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

	public CustRequestItem(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		custRequestResolutionId = (String) value
				.get(FIELD_CUST_REQUEST_RESOLUTION_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		priority = (Long) value.get(FIELD_PRIORITY);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		requiredByDate = (Timestamp) value.get(FIELD_REQUIRED_BY_DATE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		selectedAmount = (BigDecimal) value.get(FIELD_SELECTED_AMOUNT);
		maximumAmount = (BigDecimal) value.get(FIELD_MAXIMUM_AMOUNT);
		reservStart = (Timestamp) value.get(FIELD_RESERV_START);
		reservLength = (BigDecimal) value.get(FIELD_RESERV_LENGTH);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		configId = (String) value.get(FIELD_CONFIG_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		story = (String) value.get(FIELD_STORY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestItem(value);
	}

	public static List<CustRequestItem> fromValues(List<GenericValue> values) {
		List<CustRequestItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestItem(value));
		}
		return entities;
	}
}