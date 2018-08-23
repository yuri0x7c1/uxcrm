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
 * Payment Method And Eft Account
 */
@FieldNameConstants
public class PaymentMethodAndEftAccount implements Serializable {

	public static final long serialVersionUID = 236959915947411456L;
	public static final String NAME = "PaymentMethodAndEftAccount";
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
	 * Bank Name
	 */
	@Getter
	@Setter
	private String bankName;
	/**
	 * Routing Number
	 */
	@Getter
	@Setter
	private String routingNumber;
	/**
	 * Account Type
	 */
	@Getter
	@Setter
	private String accountType;
	/**
	 * Account Number
	 */
	@Getter
	@Setter
	private String accountNumber;
	/**
	 * Name On Account
	 */
	@Getter
	@Setter
	private String nameOnAccount;
	/**
	 * Company Name On Account
	 */
	@Getter
	@Setter
	private String companyNameOnAccount;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Years At Bank
	 */
	@Getter
	@Setter
	private Long yearsAtBank;

	public PaymentMethodAndEftAccount(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		bankName = (String) value.get(FIELD_BANK_NAME);
		routingNumber = (String) value.get(FIELD_ROUTING_NUMBER);
		accountType = (String) value.get(FIELD_ACCOUNT_TYPE);
		accountNumber = (String) value.get(FIELD_ACCOUNT_NUMBER);
		nameOnAccount = (String) value.get(FIELD_NAME_ON_ACCOUNT);
		companyNameOnAccount = (String) value
				.get(FIELD_COMPANY_NAME_ON_ACCOUNT);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		yearsAtBank = (Long) value.get(FIELD_YEARS_AT_BANK);
	}

	public static PaymentMethodAndEftAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodAndEftAccount(value);
	}

	public static List<PaymentMethodAndEftAccount> fromValues(
			List<GenericValue> values) {
		List<PaymentMethodAndEftAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodAndEftAccount(value));
		}
		return entities;
	}
}