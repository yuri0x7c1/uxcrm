package org.apache.ofbiz.accounting.ledger.entity;

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
public class AcctgTrans implements Serializable {

	public static final long serialVersionUID = 6715356716481444864L;
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

	public enum Fields {
		acctgTransId, acctgTransTypeId, description, transactionDate, isPosted, postedDate, scheduledPostingDate, glJournalId, glFiscalTypeId, voucherRef, voucherDate, groupStatusId, fixedAssetId, inventoryItemId, physicalInventoryId, partyId, roleTypeId, invoiceId, paymentId, finAccountTransId, shipmentId, receiptId, workEffortId, theirAcctgTransId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public AcctgTrans(GenericValue value) {
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		acctgTransTypeId = (String) value.get(Fields.acctgTransTypeId.name());
		description = (String) value.get(Fields.description.name());
		transactionDate = (Timestamp) value.get(Fields.transactionDate.name());
		isPosted = (String) value.get(Fields.isPosted.name());
		postedDate = (Timestamp) value.get(Fields.postedDate.name());
		scheduledPostingDate = (Timestamp) value
				.get(Fields.scheduledPostingDate.name());
		glJournalId = (String) value.get(Fields.glJournalId.name());
		glFiscalTypeId = (String) value.get(Fields.glFiscalTypeId.name());
		voucherRef = (String) value.get(Fields.voucherRef.name());
		voucherDate = (Timestamp) value.get(Fields.voucherDate.name());
		groupStatusId = (String) value.get(Fields.groupStatusId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		receiptId = (String) value.get(Fields.receiptId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		theirAcctgTransId = (String) value.get(Fields.theirAcctgTransId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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