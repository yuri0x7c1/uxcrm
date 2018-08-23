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
 * Payment Method And Gift Card
 */
@FieldNameConstants
public class PaymentMethodAndGiftCard implements Serializable {

	public static final long serialVersionUID = 4680779910401022976L;
	public static final String NAME = "PaymentMethodAndGiftCard";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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
	 * Card Number
	 */
	@Getter
	@Setter
	private String cardNumber;
	/**
	 * Pin Number
	 */
	@Getter
	@Setter
	private String pinNumber;
	/**
	 * Expire Date
	 */
	@Getter
	@Setter
	private String expireDate;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public PaymentMethodAndGiftCard(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		cardNumber = (String) value.get(FIELD_CARD_NUMBER);
		pinNumber = (String) value.get(FIELD_PIN_NUMBER);
		expireDate = (String) value.get(FIELD_EXPIRE_DATE);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
	}

	public static PaymentMethodAndGiftCard fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodAndGiftCard(value);
	}

	public static List<PaymentMethodAndGiftCard> fromValues(
			List<GenericValue> values) {
		List<PaymentMethodAndGiftCard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodAndGiftCard(value));
		}
		return entities;
	}
}