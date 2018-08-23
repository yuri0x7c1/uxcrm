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
 * Payment Method And Credit Card
 */
@FieldNameConstants
public class PaymentMethodAndCreditCard implements Serializable {

	public static final long serialVersionUID = 7895519718257985536L;
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

	public PaymentMethodAndCreditCard(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		cardType = (String) value.get(FIELD_CARD_TYPE);
		cardNumber = (String) value.get(FIELD_CARD_NUMBER);
		expireDate = (String) value.get(FIELD_EXPIRE_DATE);
		companyNameOnCard = (String) value.get(FIELD_COMPANY_NAME_ON_CARD);
		titleOnCard = (String) value.get(FIELD_TITLE_ON_CARD);
		firstNameOnCard = (String) value.get(FIELD_FIRST_NAME_ON_CARD);
		lastNameOnCard = (String) value.get(FIELD_LAST_NAME_ON_CARD);
		suffixOnCard = (String) value.get(FIELD_SUFFIX_ON_CARD);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
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