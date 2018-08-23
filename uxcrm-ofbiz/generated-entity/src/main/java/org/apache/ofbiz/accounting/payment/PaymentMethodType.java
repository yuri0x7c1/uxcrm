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
 * Payment Method Type
 */
@FieldNameConstants
public class PaymentMethodType implements Serializable {

	public static final long serialVersionUID = 1703320635529688064L;
	public static final String NAME = "PaymentMethodType";
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Gl Account Id
	 */
	@Getter
	@Setter
	private String defaultGlAccountId;
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

	public PaymentMethodType(GenericValue value) {
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		defaultGlAccountId = (String) value.get(FIELD_DEFAULT_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodType(value);
	}

	public static List<PaymentMethodType> fromValues(List<GenericValue> values) {
		List<PaymentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodType(value));
		}
		return entities;
	}
}