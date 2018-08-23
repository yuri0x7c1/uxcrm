package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Group Member
 */
@FieldNameConstants
public class PaymentGroupMember implements Serializable {

	public static final long serialVersionUID = 7103513980520875008L;
	public static final String NAME = "PaymentGroupMember";
	/**
	 * Payment Group Id
	 */
	@Getter
	@Setter
	private String paymentGroupId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
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
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public PaymentGroupMember(GenericValue value) {
		paymentGroupId = (String) value.get(FIELD_PAYMENT_GROUP_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGroupMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGroupMember(value);
	}

	public static List<PaymentGroupMember> fromValues(List<GenericValue> values) {
		List<PaymentGroupMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGroupMember(value));
		}
		return entities;
	}
}