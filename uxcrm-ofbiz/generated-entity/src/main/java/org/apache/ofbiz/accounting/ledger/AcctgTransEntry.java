package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class AcctgTransEntry implements Serializable {

	public static final long serialVersionUID = 1983628936599034880L;
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

	public AcctgTransEntry(GenericValue value) {
		acctgTransId = (String) value.get(FIELD_ACCTG_TRANS_ID);
		acctgTransEntrySeqId = (String) value
				.get(FIELD_ACCTG_TRANS_ENTRY_SEQ_ID);
		acctgTransEntryTypeId = (String) value
				.get(FIELD_ACCTG_TRANS_ENTRY_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		voucherRef = (String) value.get(FIELD_VOUCHER_REF);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		theirPartyId = (String) value.get(FIELD_THEIR_PARTY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		theirProductId = (String) value.get(FIELD_THEIR_PRODUCT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		glAccountTypeId = (String) value.get(FIELD_GL_ACCOUNT_TYPE_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		origAmount = (BigDecimal) value.get(FIELD_ORIG_AMOUNT);
		origCurrencyUomId = (String) value.get(FIELD_ORIG_CURRENCY_UOM_ID);
		debitCreditFlag = (String) value.get(FIELD_DEBIT_CREDIT_FLAG);
		dueDate = (Date) value.get(FIELD_DUE_DATE);
		groupId = (String) value.get(FIELD_GROUP_ID);
		taxId = (String) value.get(FIELD_TAX_ID);
		reconcileStatusId = (String) value.get(FIELD_RECONCILE_STATUS_ID);
		settlementTermId = (String) value.get(FIELD_SETTLEMENT_TERM_ID);
		isSummary = (String) value.get(FIELD_IS_SUMMARY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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