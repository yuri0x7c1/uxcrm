package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gift Card
 */
public class GiftCard implements Serializable {

	public static final long serialVersionUID = 7781563926409219072L;
	public static final String NAME = "GiftCard";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
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
		paymentMethodId, cardNumber, pinNumber, expireDate, contactMechId
	}

	public GiftCard(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		cardNumber = (String) value.get(Fields.cardNumber.name());
		pinNumber = (String) value.get(Fields.pinNumber.name());
		expireDate = (String) value.get(Fields.expireDate.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static GiftCard fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GiftCard(value);
	}

	public static List<GiftCard> fromValues(List<GenericValue> values) {
		List<GiftCard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GiftCard(value));
		}
		return entities;
	}
}