package org.apache.ofbiz.accounting.payment;

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
public class PaymentAndTypeAndCreditCard implements Serializable {

	public static final long serialVersionUID = 8247489816470602752L;
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

	public enum Fields {
		roleTypeIdTo, finAccountTransId, partyIdFrom, amount, paymentPreferenceId, comments, parentTypeId, actualCurrencyAmount, overrideGlAccountId, description, paymentMethodTypeId, actualCurrencyUomId, paymentTypeId, currencyUomId, statusId, hasTable, paymentId, paymentMethodId, paymentGatewayResponseId, paymentRefNum, partyIdTo, effectiveDate, firstNameOnCard, issueNumber, cardType, lastFailedAuthDate, consecutiveFailedNsf, contactMechId, companyNameOnCard, titleOnCard, lastNameOnCard, middleNameOnCard, validFromDate, expireDate, consecutiveFailedAuths, lastFailedNsfDate, cardNumber, suffixOnCard
	}

	public PaymentAndTypeAndCreditCard(GenericValue value) {
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		comments = (String) value.get(Fields.comments.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		description = (String) value.get(Fields.description.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		actualCurrencyUomId = (String) value.get(Fields.actualCurrencyUomId
				.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentRefNum = (String) value.get(Fields.paymentRefNum.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		firstNameOnCard = (String) value.get(Fields.firstNameOnCard.name());
		issueNumber = (String) value.get(Fields.issueNumber.name());
		cardType = (String) value.get(Fields.cardType.name());
		lastFailedAuthDate = (Timestamp) value.get(Fields.lastFailedAuthDate
				.name());
		consecutiveFailedNsf = (Long) value.get(Fields.consecutiveFailedNsf
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		companyNameOnCard = (String) value.get(Fields.companyNameOnCard.name());
		titleOnCard = (String) value.get(Fields.titleOnCard.name());
		lastNameOnCard = (String) value.get(Fields.lastNameOnCard.name());
		middleNameOnCard = (String) value.get(Fields.middleNameOnCard.name());
		validFromDate = (String) value.get(Fields.validFromDate.name());
		expireDate = (String) value.get(Fields.expireDate.name());
		consecutiveFailedAuths = (Long) value.get(Fields.consecutiveFailedAuths
				.name());
		lastFailedNsfDate = (Timestamp) value.get(Fields.lastFailedNsfDate
				.name());
		cardNumber = (String) value.get(Fields.cardNumber.name());
		suffixOnCard = (String) value.get(Fields.suffixOnCard.name());
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