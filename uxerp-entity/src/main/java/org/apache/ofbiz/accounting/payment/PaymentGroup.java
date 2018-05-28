package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Group
 */
public class PaymentGroup implements Serializable {

	public static final long serialVersionUID = 2456984225501715456L;
	public static final String NAME = "PaymentGroup";
	/**
	 * Payment Group Id
	 */
	@Getter
	@Setter
	private String paymentGroupId;
	/**
	 * Payment Group Type Id
	 */
	@Getter
	@Setter
	private String paymentGroupTypeId;
	/**
	 * Payment Group Name
	 */
	@Getter
	@Setter
	private String paymentGroupName;
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
		paymentGroupId, paymentGroupTypeId, paymentGroupName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGroup(GenericValue value) {
		paymentGroupId = (String) value.get(Fields.paymentGroupId.name());
		paymentGroupTypeId = (String) value.get(Fields.paymentGroupTypeId
				.name());
		paymentGroupName = (String) value.get(Fields.paymentGroupName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGroup(value);
	}

	public static List<PaymentGroup> fromValues(List<GenericValue> values) {
		List<PaymentGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGroup(value));
		}
		return entities;
	}
}