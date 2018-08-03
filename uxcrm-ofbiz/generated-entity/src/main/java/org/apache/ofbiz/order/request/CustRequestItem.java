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
 * Cust Request Item
 */
public class CustRequestItem implements Serializable {

	public static final long serialVersionUID = 1736375770122734592L;
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

	public enum Fields {
		custRequestId, custRequestItemSeqId, custRequestResolutionId, statusId, priority, sequenceNum, requiredByDate, productId, quantity, selectedAmount, maximumAmount, reservStart, reservLength, reservPersons, configId, description, story, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestItem(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		custRequestResolutionId = (String) value
				.get(Fields.custRequestResolutionId.name());
		statusId = (String) value.get(Fields.statusId.name());
		priority = (Long) value.get(Fields.priority.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		selectedAmount = (BigDecimal) value.get(Fields.selectedAmount.name());
		maximumAmount = (BigDecimal) value.get(Fields.maximumAmount.name());
		reservStart = (Timestamp) value.get(Fields.reservStart.name());
		reservLength = (BigDecimal) value.get(Fields.reservLength.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		configId = (String) value.get(Fields.configId.name());
		description = (String) value.get(Fields.description.name());
		story = (String) value.get(Fields.story.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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