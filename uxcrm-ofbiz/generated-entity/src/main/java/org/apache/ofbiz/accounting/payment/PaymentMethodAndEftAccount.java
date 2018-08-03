package org.apache.ofbiz.accounting.payment;

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
public class PaymentMethodAndEftAccount implements Serializable {

	public static final long serialVersionUID = 6271164320822302720L;
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

	public enum Fields {
		paymentMethodId, paymentMethodTypeId, partyId, glAccountId, fromDate, thruDate, bankName, routingNumber, accountType, accountNumber, nameOnAccount, companyNameOnAccount, contactMechId, yearsAtBank
	}

	public PaymentMethodAndEftAccount(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		bankName = (String) value.get(Fields.bankName.name());
		routingNumber = (String) value.get(Fields.routingNumber.name());
		accountType = (String) value.get(Fields.accountType.name());
		accountNumber = (String) value.get(Fields.accountNumber.name());
		nameOnAccount = (String) value.get(Fields.nameOnAccount.name());
		companyNameOnAccount = (String) value.get(Fields.companyNameOnAccount
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		yearsAtBank = (Long) value.get(Fields.yearsAtBank.name());
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