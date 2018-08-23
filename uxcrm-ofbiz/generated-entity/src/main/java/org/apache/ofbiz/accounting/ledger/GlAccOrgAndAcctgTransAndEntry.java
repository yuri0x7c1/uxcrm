package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Acc Org And Acctg Trans And Entry
 */
@FieldNameConstants
public class GlAccOrgAndAcctgTransAndEntry implements Serializable {

	public static final long serialVersionUID = 8146356873097881600L;
	public static final String NAME = "GlAccOrgAndAcctgTransAndEntry";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Debit Credit Flag
	 */
	@Getter
	@Setter
	private String debitCreditFlag;
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
	/**
	 * Acctg Trans Id
	 */
	@Getter
	@Setter
	private String acctgTransId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Total Amount
	 */
	@Getter
	@Setter
	private BigDecimal totalAmount;
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

	public GlAccOrgAndAcctgTransAndEntry(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		debitCreditFlag = (String) value.get(FIELD_DEBIT_CREDIT_FLAG);
		isPosted = (String) value.get(FIELD_IS_POSTED);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
		acctgTransId = (String) value.get(FIELD_ACCTG_TRANS_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		totalAmount = (BigDecimal) value.get(FIELD_TOTAL_AMOUNT);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static GlAccOrgAndAcctgTransAndEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccOrgAndAcctgTransAndEntry(value);
	}

	public static List<GlAccOrgAndAcctgTransAndEntry> fromValues(
			List<GenericValue> values) {
		List<GlAccOrgAndAcctgTransAndEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccOrgAndAcctgTransAndEntry(value));
		}
		return entities;
	}
}