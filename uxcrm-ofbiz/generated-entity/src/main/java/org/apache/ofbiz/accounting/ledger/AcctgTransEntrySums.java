package org.apache.ofbiz.accounting.ledger;

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
public class AcctgTransEntrySums implements Serializable {

	public static final long serialVersionUID = 4182073704679746560L;
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

	public enum Fields {
		glAccountId, glAccountTypeId, glAccountClassId, accountName, accountCode, glFiscalTypeId, acctgTransTypeId, debitCreditFlag, amount, organizationPartyId, isPosted, transactionDate
	}

	public AcctgTransEntrySums(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		accountName = (String) value.get(Fields.accountName.name());
		accountCode = (String) value.get(Fields.accountCode.name());
		glFiscalTypeId = (String) value.get(Fields.glFiscalTypeId.name());
		acctgTransTypeId = (String) value.get(Fields.acctgTransTypeId.name());
		debitCreditFlag = (String) value.get(Fields.debitCreditFlag.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		isPosted = (String) value.get(Fields.isPosted.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
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