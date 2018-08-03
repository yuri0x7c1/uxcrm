package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Method And Credit Card
 */
public class PaymentMethodAndCreditCard implements Serializable {

	public static final long serialVersionUID = 8416110897871041536L;
	public static final String NAME = "PaymentMethodAndCreditCard";
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Card Type
	 */
	@Getter
	@Setter
	private String cardType;
	/**
	 * Card Number
	 */
	@Getter
	@Setter
	private String cardNumber;
	/**
	 * Expire Date
	 */
	@Getter
	@Setter
	private String expireDate;
	/**
	 * Company Name On Card
	 */
	@Getter
	@Setter
	private String companyNameOnCard;
	/**
	 * Title On Card
	 */
	@Getter
	@Setter
	private String titleOnCard;
	/**
	 * First Name On Card
	 */
	@Getter
	@Setter
	private String firstNameOnCard;
	/**
	 * Last Name On Card
	 */
	@Getter
	@Setter
	private String lastNameOnCard;
	/**
	 * Suffix On Card
	 */
	@Getter
	@Setter
	private String suffixOnCard;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public enum Fields {
		paymentMethodId, paymentMethodTypeId, partyId, glAccountId, fromDate, thruDate, description, cardType, cardNumber, expireDate, companyNameOnCard, titleOnCard, firstNameOnCard, lastNameOnCard, suffixOnCard, contactMechId
	}

	public PaymentMethodAndCreditCard(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		description = (String) value.get(Fields.description.name());
		cardType = (String) value.get(Fields.cardType.name());
		cardNumber = (String) value.get(Fields.cardNumber.name());
		expireDate = (String) value.get(Fields.expireDate.name());
		companyNameOnCard = (String) value.get(Fields.companyNameOnCard.name());
		titleOnCard = (String) value.get(Fields.titleOnCard.name());
		firstNameOnCard = (String) value.get(Fields.firstNameOnCard.name());
		lastNameOnCard = (String) value.get(Fields.lastNameOnCard.name());
		suffixOnCard = (String) value.get(Fields.suffixOnCard.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static PaymentMethodAndCreditCard fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodAndCreditCard(value);
	}

	public static List<PaymentMethodAndCreditCard> fromValues(
			List<GenericValue> values) {
		List<PaymentMethodAndCreditCard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodAndCreditCard(value));
		}
		return entities;
	}
}