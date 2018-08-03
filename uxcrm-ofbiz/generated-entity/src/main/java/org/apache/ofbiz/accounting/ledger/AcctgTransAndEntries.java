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
 * Acctg Trans And Entries
 */
public class AcctgTransAndEntries implements Serializable {

	public static final long serialVersionUID = 1310047883784685568L;
	public static final String NAME = "AcctgTransAndEntries";
	/**
	 * Is Posted
	 */
	@Getter
	@Setter
	private String isPosted;
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
	 * Transaction Date
	 */
	@Getter
	@Setter
	private Timestamp transactionDate;
	/**
	 * Posted Date
	 */
	@Getter
	@Setter
	private Timestamp postedDate;
	/**
	 * Trans Description
	 */
	@Getter
	@Setter
	private String transDescription;
	/**
	 * Gl Journal Id
	 */
	@Getter
	@Setter
	private String glJournalId;
	/**
	 * Trans Type Description
	 */
	@Getter
	@Setter
	private String transTypeDescription;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Account Code
	 */
	@Getter
	@Setter
	private String accountCode;
	/**
	 * Account Name
	 */
	@Getter
	@Setter
	private String accountName;
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Reconcile Status Id
	 */
	@Getter
	@Setter
	private String reconcileStatusId;
	/**
	 * Acctg Trans Entry Type Id
	 */
	@Getter
	@Setter
	private String acctgTransEntryTypeId;

	public enum Fields {
		isPosted, glFiscalTypeId, acctgTransTypeId, transactionDate, postedDate, transDescription, glJournalId, transTypeDescription, invoiceId, paymentId, shipmentId, receiptId, inventoryItemId, workEffortId, fixedAssetId, physicalInventoryId, description, acctgTransId, acctgTransEntrySeqId, glAccountId, productId, debitCreditFlag, amount, currencyUomId, origAmount, origCurrencyUomId, organizationPartyId, glAccountTypeId, accountCode, accountName, glAccountClassId, partyId, reconcileStatusId, acctgTransEntryTypeId
	}

	public AcctgTransAndEntries(GenericValue value) {
		isPosted = (String) value.get(Fields.isPosted.name());
		glFiscalTypeId = (String) value.get(Fields.glFiscalTypeId.name());
		acctgTransTypeId = (String) value.get(Fields.acctgTransTypeId.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
		postedDate = (Timestamp) value.get(Fields.postedDate.name());
		transDescription = (String) value.get(Fields.transDescription.name());
		glJournalId = (String) value.get(Fields.glJournalId.name());
		transTypeDescription = (String) value.get(Fields.transTypeDescription
				.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		receiptId = (String) value.get(Fields.receiptId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		description = (String) value.get(Fields.description.name());
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		acctgTransEntrySeqId = (String) value.get(Fields.acctgTransEntrySeqId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		productId = (String) value.get(Fields.productId.name());
		debitCreditFlag = (String) value.get(Fields.debitCreditFlag.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		origAmount = (BigDecimal) value.get(Fields.origAmount.name());
		origCurrencyUomId = (String) value.get(Fields.origCurrencyUomId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		accountCode = (String) value.get(Fields.accountCode.name());
		accountName = (String) value.get(Fields.accountName.name());
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		partyId = (String) value.get(Fields.partyId.name());
		reconcileStatusId = (String) value.get(Fields.reconcileStatusId.name());
		acctgTransEntryTypeId = (String) value.get(Fields.acctgTransEntryTypeId
				.name());
	}

	public static AcctgTransAndEntries fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransAndEntries(value);
	}

	public static List<AcctgTransAndEntries> fromValues(
			List<GenericValue> values) {
		List<AcctgTransAndEntries> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransAndEntries(value));
		}
		return entities;
	}
}