package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans Entry
 */
public class AcctgTransEntry implements Serializable {

	public static final long serialVersionUID = 4799136972988309504L;
	public static final String NAME = "AcctgTransEntry";
	/**
	 * Acctg Trans Id
	 */
	@Getter
	@Setter
	private String acctgTransId;
	/**
	 * Acctg Trans Entry Seq Id
	 */
	@Getter
	@Setter
	private String acctgTransEntrySeqId;
	/**
	 * Acctg Trans Entry Type Id
	 */
	@Getter
	@Setter
	private String acctgTransEntryTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Voucher Ref
	 */
	@Getter
	@Setter
	private String voucherRef;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Their Party Id
	 */
	@Getter
	@Setter
	private String theirPartyId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Their Product Id
	 */
	@Getter
	@Setter
	private String theirProductId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Orig Amount
	 */
	@Getter
	@Setter
	private BigDecimal origAmount;
	/**
	 * Orig Currency Uom Id
	 */
	@Getter
	@Setter
	private String origCurrencyUomId;
	/**
	 * Debit Credit Flag
	 */
	@Getter
	@Setter
	private String debitCreditFlag;
	/**
	 * Due Date
	 */
	@Getter
	@Setter
	private Date dueDate;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Tax Id
	 */
	@Getter
	@Setter
	private String taxId;
	/**
	 * Reconcile Status Id
	 */
	@Getter
	@Setter
	private String reconcileStatusId;
	/**
	 * Settlement Term Id
	 */
	@Getter
	@Setter
	private String settlementTermId;
	/**
	 * Is Summary
	 */
	@Getter
	@Setter
	private String isSummary;
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
		acctgTransId, acctgTransEntrySeqId, acctgTransEntryTypeId, description, voucherRef, partyId, roleTypeId, theirPartyId, productId, theirProductId, inventoryItemId, glAccountTypeId, glAccountId, organizationPartyId, amount, currencyUomId, origAmount, origCurrencyUomId, debitCreditFlag, dueDate, groupId, taxId, reconcileStatusId, settlementTermId, isSummary, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AcctgTransEntry(GenericValue value) {
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		acctgTransEntrySeqId = (String) value.get(Fields.acctgTransEntrySeqId
				.name());
		acctgTransEntryTypeId = (String) value.get(Fields.acctgTransEntryTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		voucherRef = (String) value.get(Fields.voucherRef.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		theirPartyId = (String) value.get(Fields.theirPartyId.name());
		productId = (String) value.get(Fields.productId.name());
		theirProductId = (String) value.get(Fields.theirProductId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		origAmount = (BigDecimal) value.get(Fields.origAmount.name());
		origCurrencyUomId = (String) value.get(Fields.origCurrencyUomId.name());
		debitCreditFlag = (String) value.get(Fields.debitCreditFlag.name());
		dueDate = (Date) value.get(Fields.dueDate.name());
		groupId = (String) value.get(Fields.groupId.name());
		taxId = (String) value.get(Fields.taxId.name());
		reconcileStatusId = (String) value.get(Fields.reconcileStatusId.name());
		settlementTermId = (String) value.get(Fields.settlementTermId.name());
		isSummary = (String) value.get(Fields.isSummary.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AcctgTransEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransEntry(value);
	}

	public static List<AcctgTransEntry> fromValues(List<GenericValue> values) {
		List<AcctgTransEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransEntry(value));
		}
		return entities;
	}
}