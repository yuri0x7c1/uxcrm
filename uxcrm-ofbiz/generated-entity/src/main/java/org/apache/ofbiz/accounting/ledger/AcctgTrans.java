package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans
 */
@FieldNameConstants
public class AcctgTrans implements Serializable {

	public static final long serialVersionUID = 2188398451403752448L;
	public static final String NAME = "AcctgTrans";
	/**
	 * Acctg Trans Id
	 */
	@Getter
	@Setter
	private String acctgTransId;
	/**
	 * Acctg Trans Type Id
	 */
	@Getter
	@Setter
	private String acctgTransTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Transaction Date
	 */
	@Getter
	@Setter
	private Timestamp transactionDate;
	/**
	 * Is Posted
	 */
	@Getter
	@Setter
	private String isPosted;
	/**
	 * Posted Date
	 */
	@Getter
	@Setter
	private Timestamp postedDate;
	/**
	 * Scheduled Posting Date
	 */
	@Getter
	@Setter
	private Timestamp scheduledPostingDate;
	/**
	 * Gl Journal Id
	 */
	@Getter
	@Setter
	private String glJournalId;
	/**
	 * Gl Fiscal Type Id
	 */
	@Getter
	@Setter
	private String glFiscalTypeId;
	/**
	 * Voucher Ref
	 */
	@Getter
	@Setter
	private String voucherRef;
	/**
	 * Voucher Date
	 */
	@Getter
	@Setter
	private Timestamp voucherDate;
	/**
	 * Group Status Id
	 */
	@Getter
	@Setter
	private String groupStatusId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
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
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
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
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Their Acctg Trans Id
	 */
	@Getter
	@Setter
	private String theirAcctgTransId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public AcctgTrans(GenericValue value) {
		acctgTransId = (String) value.get(FIELD_ACCTG_TRANS_ID);
		acctgTransTypeId = (String) value.get(FIELD_ACCTG_TRANS_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		transactionDate = (Timestamp) value.get(FIELD_TRANSACTION_DATE);
		isPosted = (String) value.get(FIELD_IS_POSTED);
		postedDate = (Timestamp) value.get(FIELD_POSTED_DATE);
		scheduledPostingDate = (Timestamp) value
				.get(FIELD_SCHEDULED_POSTING_DATE);
		glJournalId = (String) value.get(FIELD_GL_JOURNAL_ID);
		glFiscalTypeId = (String) value.get(FIELD_GL_FISCAL_TYPE_ID);
		voucherRef = (String) value.get(FIELD_VOUCHER_REF);
		voucherDate = (Timestamp) value.get(FIELD_VOUCHER_DATE);
		groupStatusId = (String) value.get(FIELD_GROUP_STATUS_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		theirAcctgTransId = (String) value.get(FIELD_THEIR_ACCTG_TRANS_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AcctgTrans fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTrans(value);
	}

	public static List<AcctgTrans> fromValues(List<GenericValue> values) {
		List<AcctgTrans> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTrans(value));
		}
		return entities;
	}
}