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
 * Credit Card
 */
@FieldNameConstants
public class CreditCard implements Serializable {

	public static final long serialVersionUID = 3375233650682853376L;
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

	public CreditCard(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		cardType = (String) value.get(FIELD_CARD_TYPE);
		cardNumber = (String) value.get(FIELD_CARD_NUMBER);
		validFromDate = (String) value.get(FIELD_VALID_FROM_DATE);
		expireDate = (String) value.get(FIELD_EXPIRE_DATE);
		issueNumber = (String) value.get(FIELD_ISSUE_NUMBER);
		companyNameOnCard = (String) value.get(FIELD_COMPANY_NAME_ON_CARD);
		titleOnCard = (String) value.get(FIELD_TITLE_ON_CARD);
		firstNameOnCard = (String) value.get(FIELD_FIRST_NAME_ON_CARD);
		middleNameOnCard = (String) value.get(FIELD_MIDDLE_NAME_ON_CARD);
		lastNameOnCard = (String) value.get(FIELD_LAST_NAME_ON_CARD);
		suffixOnCard = (String) value.get(FIELD_SUFFIX_ON_CARD);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		consecutiveFailedAuths = (Long) value
				.get(FIELD_CONSECUTIVE_FAILED_AUTHS);
		lastFailedAuthDate = (Timestamp) value.get(FIELD_LAST_FAILED_AUTH_DATE);
		consecutiveFailedNsf = (Long) value.get(FIELD_CONSECUTIVE_FAILED_NSF);
		lastFailedNsfDate = (Timestamp) value.get(FIELD_LAST_FAILED_NSF_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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