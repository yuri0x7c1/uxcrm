package org.apache.ofbiz.accounting.ledger;

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
 * Acctg Trans Entry Sums
 */
@FieldNameConstants
public class AcctgTransEntrySums implements Serializable {

	public static final long serialVersionUID = 5766333958739687424L;
	public static final String NAME = "AcctgTransEntrySums";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Account Name
	 */
	@Getter
	@Setter
	private String accountName;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Gl Fiscal Type Id
	 */
	@Getter
	@Setter
	private String glFiscalTypeId;
	/**
	 * Acctg Trans Type Id
	 */
	@Getter
	@Setter
	private String acctgTransTypeId;
	/**
	 * Debit Credit Flag
	 */
	@Getter
	@Setter
	private String debitCreditFlag;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Is Posted
	 */
	@Getter
	@Setter
	private String isPosted;
	/**
	 * Transaction Date
	 */
	@Getter
	@Setter
	private Timestamp transactionDate;

	public AcctgTransEntrySums(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		glAccountClassId = (String) value.get(FIELD_GL_ACCOUNT_CLASS_ID);
		accountName = (String) value.get(FIELD_ACCOUNT_NAME);
		accountCode = (String) value.get(FIELD_ACCOUNT_CODE);
		glFiscalTypeId = (String) value.get(FIELD_GL_FISCAL_TYPE_ID);
		acctgTransTypeId = (String) value.get(FIELD_ACCTG_TRANS_TYPE_ID);
		debitCreditFlag = (String) value.get(FIELD_DEBIT_CREDIT_FLAG);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		isPosted = (String) value.get(FIELD_IS_POSTED);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
	}

	public static AcctgTransEntrySums fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransEntrySums(value);
	}

	public static List<AcctgTransEntrySums> fromValues(List<GenericValue> values) {
		List<AcctgTransEntrySums> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransEntrySums(value));
		}
		return entities;
	}
}