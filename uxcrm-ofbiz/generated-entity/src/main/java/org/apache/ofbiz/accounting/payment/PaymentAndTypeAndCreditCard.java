package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment And Type And Credit Card
 */
@FieldNameConstants
public class PaymentAndTypeAndCreditCard implements Serializable {

	public static final long serialVersionUID = 1746822170918216704L;
	public static final String NAME = "PaymentAndTypeAndCreditCard";
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Payment Preference Id
	 */
	@Getter
	@Setter
	private String paymentPreferenceId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Actual Currency Amount
	 */
	@Getter
	@Setter
	private BigDecimal actualCurrencyAmount;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Actual Currency Uom Id
	 */
	@Getter
	@Setter
	private String actualCurrencyUomId;
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Payment Gateway Response Id
	 */
	@Getter
	@Setter
	private String paymentGatewayResponseId;
	/**
	 * Payment Ref Num
	 */
	@Getter
	@Setter
	private String paymentRefNum;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;
	/**
	 * First Name On Card
	 */
	@Getter
	@Setter
	private String firstNameOnCard;
	/**
	 * Issue Number
	 */
	@Getter
	@Setter
	private String issueNumber;
	/**
	 * Card Type
	 */
	@Getter
	@Setter
	private String cardType;
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
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Last Name On Card
	 */
	@Getter
	@Setter
	private String lastNameOnCard;
	/**
	 * Middle Name On Card
	 */
	@Getter
	@Setter
	private String middleNameOnCard;
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
	 * Consecutive Failed Auths
	 */
	@Getter
	@Setter
	private Long consecutiveFailedAuths;
	/**
	 * Last Failed Nsf Date
	 */
	@Getter
	@Setter
	private Timestamp lastFailedNsfDate;
	/**
	 * Card Number
	 */
	@Getter
	@Setter
	private String cardNumber;
	/**
	 * Suffix On Card
	 */
	@Getter
	@Setter
	private String suffixOnCard;

	public PaymentAndTypeAndCreditCard(GenericValue value) {
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		paymentPreferenceId = (String) value.get(FIELD_PAYMENT_PREFERENCE_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		actualCurrencyAmount = (BigDecimal) value
				.get(FIELD_ACTUAL_CURRENCY_AMOUNT);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		actualCurrencyUomId = (String) value.get(FIELD_ACTUAL_CURRENCY_UOM_ID);
		paymentTypeId = (String) value.get(FIELD_PAYMENT_TYPE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentGatewayResponseId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESPONSE_ID);
		paymentRefNum = (String) value.get(FIELD_PAYMENT_REF_NUM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
		firstNameOnCard = (String) value.get(FIELD_FIRST_NAME_ON_CARD);
		issueNumber = (String) value.get(FIELD_ISSUE_NUMBER);
		cardType = (String) value.get(FIELD_CARD_TYPE);
		lastFailedAuthDate = (Timestamp) value.get(FIELD_LAST_FAILED_AUTH_DATE);
		consecutiveFailedNsf = (Long) value.get(FIELD_CONSECUTIVE_FAILED_NSF);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		companyNameOnCard = (String) value.get(FIELD_COMPANY_NAME_ON_CARD);
		titleOnCard = (String) value.get(FIELD_TITLE_ON_CARD);
		lastNameOnCard = (String) value.get(FIELD_LAST_NAME_ON_CARD);
		middleNameOnCard = (String) value.get(FIELD_MIDDLE_NAME_ON_CARD);
		validFromDate = (String) value.get(FIELD_VALID_FROM_DATE);
		expireDate = (String) value.get(FIELD_EXPIRE_DATE);
		consecutiveFailedAuths = (Long) value
				.get(FIELD_CONSECUTIVE_FAILED_AUTHS);
		lastFailedNsfDate = (Timestamp) value.get(FIELD_LAST_FAILED_NSF_DATE);
		cardNumber = (String) value.get(FIELD_CARD_NUMBER);
		suffixOnCard = (String) value.get(FIELD_SUFFIX_ON_CARD);
	}

	public static PaymentAndTypeAndCreditCard fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentAndTypeAndCreditCard(value);
	}

	public static List<PaymentAndTypeAndCreditCard> fromValues(
			List<GenericValue> values) {
		List<PaymentAndTypeAndCreditCard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentAndTypeAndCreditCard(value));
		}
		return entities;
	}
}