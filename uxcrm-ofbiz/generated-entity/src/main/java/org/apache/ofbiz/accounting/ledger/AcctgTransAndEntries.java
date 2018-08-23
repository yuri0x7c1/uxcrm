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
 * Acctg Trans And Entries
 */
@FieldNameConstants
public class AcctgTransAndEntries implements Serializable {

	public static final long serialVersionUID = 4175934813836177408L;
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

	public AcctgTransAndEntries(GenericValue value) {
		isPosted = (String) value.get(FIELD_IS_POSTED);
		glFiscalTypeId = (String) value.get(FIELD_GL_FISCAL_TYPE_ID);
		acctgTransTypeId = (String) value.get(FIELD_ACCTG_TRANS_TYPE_ID);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
		postedDate = (Timestamp) value.get(FIELD_POSTED_DATE);
		transDescription = (String) value.get(FIELD_TRANS_DESCRIPTION);
		glJournalId = (String) value.get(FIELD_GL_JOURNAL_ID);
		transTypeDescription = (String) value.get(FIELD_TRANS_TYPE_DESCRIPTION);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		acctgTransId = (String) value.get(FIELD_ACCTG_TRANS_ID);
		acctgTransEntrySeqId = (String) value
				.get(FIELD_ACCTG_TRANS_ENTRY_SEQ_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		debitCreditFlag = (String) value.get(FIELD_DEBIT_CREDIT_FLAG);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		origAmount = (BigDecimal) value.get(FIELD_ORIG_AMOUNT);
		origCurrencyUomId = (String) value.get(FIELD_ORIG_CURRENCY_UOM_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		accountCode = (String) value.get(FIELD_ACCOUNT_CODE);
		accountName = (String) value.get(FIELD_ACCOUNT_NAME);
		glAccountClassId = (String) value.get(FIELD_GL_ACCOUNT_CLASS_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		reconcileStatusId = (String) value.get(FIELD_RECONCILE_STATUS_ID);
		acctgTransEntryTypeId = (String) value
				.get(FIELD_ACCTG_TRANS_ENTRY_TYPE_ID);
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