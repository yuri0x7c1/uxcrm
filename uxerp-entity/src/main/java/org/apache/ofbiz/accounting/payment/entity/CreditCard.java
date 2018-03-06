package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Credit Card
 */
public class CreditCard implements Serializable {

	public static final long serialVersionUID = 4974586307741062144L;
	public static final String NAME = "CreditCard";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
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
	 * Valid From Date
	 */
	@Getter
	@Setter
	private String validFromDate;
	/**
	 * Expire Date
	 */
	@Getter
	@Setter
	private String expireDate;
	/**
	 * Issue Number
	 */
	@Getter
	@Setter
	private String issueNumber;
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
	 * Middle Name On Card
	 */
	@Getter
	@Setter
	private String middleNameOnCard;
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
	/**
	 * Consecutive Failed Auths
	 */
	@Getter
	@Setter
	private Long consecutiveFailedAuths;
	/**
	 * Last Failed Auth Date
	 */
	@Getter
	@Setter
	private Timestamp lastFailedAuthDate;
	/**
	 * Consecutive Failed Nsf
	 */
	@Getter
	@Setter
	private Long consecutiveFailedNsf;
	/**
	 * Last Failed Nsf Date
	 */
	@Getter
	@Setter
	private Timestamp lastFailedNsfDate;

	public enum Fields {
		paymentMethodId, cardType, cardNumber, validFromDate, expireDate, issueNumber, companyNameOnCard, titleOnCard, firstNameOnCard, middleNameOnCard, lastNameOnCard, suffixOnCard, contactMechId, consecutiveFailedAuths, lastFailedAuthDate, consecutiveFailedNsf, lastFailedNsfDate
	}

	public CreditCard(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		cardType = (String) value.get(Fields.cardType.name());
		cardNumber = (String) value.get(Fields.cardNumber.name());
		validFromDate = (String) value.get(Fields.validFromDate.name());
		expireDate = (String) value.get(Fields.expireDate.name());
		issueNumber = (String) value.get(Fields.issueNumber.name());
		companyNameOnCard = (String) value.get(Fields.companyNameOnCard.name());
		titleOnCard = (String) value.get(Fields.titleOnCard.name());
		firstNameOnCard = (String) value.get(Fields.firstNameOnCard.name());
		middleNameOnCard = (String) value.get(Fields.middleNameOnCard.name());
		lastNameOnCard = (String) value.get(Fields.lastNameOnCard.name());
		suffixOnCard = (String) value.get(Fields.suffixOnCard.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		consecutiveFailedAuths = (Long) value.get(Fields.consecutiveFailedAuths
				.name());
		lastFailedAuthDate = (Timestamp) value.get(Fields.lastFailedAuthDate
				.name());
		consecutiveFailedNsf = (Long) value.get(Fields.consecutiveFailedNsf
				.name());
		lastFailedNsfDate = (Timestamp) value.get(Fields.lastFailedNsfDate
				.name());
	}

	public static CreditCard fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CreditCard(value);
	}

	public static List<CreditCard> fromValues(List<GenericValue> values) {
		List<CreditCard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CreditCard(value));
		}
		return entities;
	}
}