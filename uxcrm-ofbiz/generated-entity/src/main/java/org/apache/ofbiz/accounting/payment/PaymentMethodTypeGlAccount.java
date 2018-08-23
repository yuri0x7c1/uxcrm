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
 * Payment Method Type Gl Account
 */
@FieldNameConstants
public class PaymentMethodTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 666576282872389632L;
	public static final String NAME = "PaymentMethodTypeGlAccount";
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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

	public PaymentMethodTypeGlAccount(GenericValue value) {
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentMethodTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodTypeGlAccount(value);
	}

	public static List<PaymentMethodTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<PaymentMethodTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodTypeGlAccount(value));
		}
		return entities;
	}
}