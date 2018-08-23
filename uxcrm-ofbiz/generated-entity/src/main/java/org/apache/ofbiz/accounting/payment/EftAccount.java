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
 * Eft Account
 */
@FieldNameConstants
public class EftAccount implements Serializable {

	public static final long serialVersionUID = 6888546686279554048L;
	public static final String NAME = "EftAccount";
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
	 * Years At Bank
	 */
	@Getter
	@Setter
	private Long yearsAtBank;
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

	public EftAccount(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		bankName = (String) value.get(FIELD_BANK_NAME);
		routingNumber = (String) value.get(FIELD_ROUTING_NUMBER);
		accountType = (String) value.get(FIELD_ACCOUNT_TYPE);
		accountNumber = (String) value.get(FIELD_ACCOUNT_NUMBER);
		nameOnAccount = (String) value.get(FIELD_NAME_ON_ACCOUNT);
		companyNameOnAccount = (String) value
				.get(FIELD_COMPANY_NAME_ON_ACCOUNT);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		yearsAtBank = (Long) value.get(FIELD_YEARS_AT_BANK);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EftAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EftAccount(value);
	}

	public static List<EftAccount> fromValues(List<GenericValue> values) {
		List<EftAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EftAccount(value));
		}
		return entities;
	}
}