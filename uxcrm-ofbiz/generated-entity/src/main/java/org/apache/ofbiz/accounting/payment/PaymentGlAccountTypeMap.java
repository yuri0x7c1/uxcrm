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
 * Payment Gl Account Type Map
 */
@FieldNameConstants
public class PaymentGlAccountTypeMap implements Serializable {

	public static final long serialVersionUID = 4637008623047696384L;
	public static final String NAME = "PaymentGlAccountTypeMap";
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
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

	public PaymentGlAccountTypeMap(GenericValue value) {
		paymentTypeId = (String) value.get(FIELD_PAYMENT_TYPE_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGlAccountTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGlAccountTypeMap(value);
	}

	public static List<PaymentGlAccountTypeMap> fromValues(
			List<GenericValue> values) {
		List<PaymentGlAccountTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGlAccountTypeMap(value));
		}
		return entities;
	}
}