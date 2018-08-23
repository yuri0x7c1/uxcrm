package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice
 */
@FieldNameConstants
public class Invoice implements Serializable {

	public static final long serialVersionUID = 4934313929950760960L;
	public static final String NAME = "Invoice";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Invoice Date
	 */
	@Getter
	@Setter
	private Timestamp invoiceDate;
	/**
	 * Due Date
	 */
	@Getter
	@Setter
	private Timestamp dueDate;
	/**
	 * Paid Date
	 */
	@Getter
	@Setter
	private Timestamp paidDate;
	/**
	 * Invoice Message
	 */
	@Getter
	@Setter
	private String invoiceMessage;
	/**
	 * Reference Number
	 */
	@Getter
	@Setter
	private String referenceNumber;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
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

	public Invoice(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceTypeId = (String) value.get(FIELD_INVOICE_TYPE_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		invoiceDate = (Timestamp) value.get(FIELD_INVOICE_DATE);
		dueDate = (Timestamp) value.get(FIELD_DUE_DATE);
		paidDate = (Timestamp) value.get(FIELD_PAID_DATE);
		invoiceMessage = (String) value.get(FIELD_INVOICE_MESSAGE);
		referenceNumber = (String) value.get(FIELD_REFERENCE_NUMBER);
		description = (String) value.get(FIELD_DESCRIPTION);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Invoice fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Invoice(value);
	}

	public static List<Invoice> fromValues(List<GenericValue> values) {
		List<Invoice> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Invoice(value));
		}
		return entities;
	}
}