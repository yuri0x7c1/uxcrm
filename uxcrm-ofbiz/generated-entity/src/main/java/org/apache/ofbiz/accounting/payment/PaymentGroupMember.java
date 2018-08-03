package org.apache.ofbiz.accounting.payment;

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
public class PaymentGroupMember implements Serializable {

	public static final long serialVersionUID = 6162500002980850688L;
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

	public enum Fields {
		paymentGroupId, paymentId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGroupMember(GenericValue value) {
		paymentGroupId = (String) value.get(Fields.paymentGroupId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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