package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Check Account
 */
public class CheckAccount implements Serializable {

	public static final long serialVersionUID = 3406299146582964224L;
	public static final String NAME = "CheckAccount";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
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
	 * Branch Code
	 */
	@Getter
	@Setter
	private String branchCode;
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

	public enum Fields {
		paymentMethodId, bankName, routingNumber, accountType, accountNumber, nameOnAccount, companyNameOnAccount, contactMechId, branchCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CheckAccount(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		bankName = (String) value.get(Fields.bankName.name());
		routingNumber = (String) value.get(Fields.routingNumber.name());
		accountType = (String) value.get(Fields.accountType.name());
		accountNumber = (String) value.get(Fields.accountNumber.name());
		nameOnAccount = (String) value.get(Fields.nameOnAccount.name());
		companyNameOnAccount = (String) value.get(Fields.companyNameOnAccount
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		branchCode = (String) value.get(Fields.branchCode.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CheckAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CheckAccount(value);
	}

	public static List<CheckAccount> fromValues(List<GenericValue> values) {
		List<CheckAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CheckAccount(value));
		}
		return entities;
	}
}