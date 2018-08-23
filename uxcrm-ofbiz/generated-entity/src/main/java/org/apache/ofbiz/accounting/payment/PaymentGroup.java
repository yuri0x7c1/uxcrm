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
 * Payment Group
 */
@FieldNameConstants
public class PaymentGroup implements Serializable {

	public static final long serialVersionUID = 7830897196926019584L;
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

	public PaymentGroup(GenericValue value) {
		paymentGroupId = (String) value.get(FIELD_PAYMENT_GROUP_ID);
		paymentGroupTypeId = (String) value.get(FIELD_PAYMENT_GROUP_TYPE_ID);
		paymentGroupName = (String) value.get(FIELD_PAYMENT_GROUP_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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