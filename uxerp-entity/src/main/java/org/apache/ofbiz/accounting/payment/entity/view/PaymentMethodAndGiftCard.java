package org.apache.ofbiz.accounting.payment.entity.view;

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
public class PaymentMethodAndGiftCard implements Serializable {

	public static final long serialVersionUID = 8821450493035265024L;
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

	public enum Fields {
		paymentMethodId, paymentMethodTypeId, partyId, glAccountId, fromDate, thruDate, cardNumber, pinNumber, expireDate, contactMechId
	}

	public PaymentMethodAndGiftCard(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		cardNumber = (String) value.get(Fields.cardNumber.name());
		pinNumber = (String) value.get(Fields.pinNumber.name());
		expireDate = (String) value.get(Fields.expireDate.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
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