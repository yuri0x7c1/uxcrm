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
 * Payment Group Type
 */
@FieldNameConstants
public class PaymentGroupType implements Serializable {

	public static final long serialVersionUID = 8131712503186236416L;
	public static final String NAME = "PaymentGroupType";
	/**
	 * Payment Group Type Id
	 */
	@Getter
	@Setter
	private String paymentGroupTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public PaymentGroupType(GenericValue value) {
		paymentGroupTypeId = (String) value.get(FIELD_PAYMENT_GROUP_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGroupType(value);
	}

	public static List<PaymentGroupType> fromValues(List<GenericValue> values) {
		List<PaymentGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGroupType(value));
		}
		return entities;
	}
}