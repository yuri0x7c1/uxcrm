package org.apache.ofbiz.accounting.ledger;

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
public class GlAccOrgAndAcctgTransAndEntry implements Serializable {

	public static final long serialVersionUID = 1490680311163970560L;
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

	public enum Fields {
		glAccountId, debitCreditFlag, isPosted, transactionDate, acctgTransId, organizationPartyId, totalAmount, fromDate, thruDate
	}

	public GlAccOrgAndAcctgTransAndEntry(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		debitCreditFlag = (String) value.get(Fields.debitCreditFlag.name());
		isPosted = (String) value.get(Fields.isPosted.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		totalAmount = (BigDecimal) value.get(Fields.totalAmount.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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