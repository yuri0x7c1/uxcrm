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
 * Check Account
 */
@FieldNameConstants
public class CheckAccount implements Serializable {

	public static final long serialVersionUID = 1123899768867976192L;
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

	public CheckAccount(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		bankName = (String) value.get(FIELD_BANK_NAME);
		routingNumber = (String) value.get(FIELD_ROUTING_NUMBER);
		accountType = (String) value.get(FIELD_ACCOUNT_TYPE);
		accountNumber = (String) value.get(FIELD_ACCOUNT_NUMBER);
		nameOnAccount = (String) value.get(FIELD_NAME_ON_ACCOUNT);
		companyNameOnAccount = (String) value
				.get(FIELD_COMPANY_NAME_ON_ACCOUNT);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		branchCode = (String) value.get(FIELD_BRANCH_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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