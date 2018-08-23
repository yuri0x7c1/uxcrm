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
 * Invoice And Type
 */
@FieldNameConstants
public class InvoiceAndType implements Serializable {

	public static final long serialVersionUID = 2911572892660586496L;
	public static final String NAME = "InvoiceAndType";
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Invoice Type Desc
	 */
	@Getter
	@Setter
	private String invoiceTypeDesc;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Due Date
	 */
	@Getter
	@Setter
	private Timestamp dueDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Invoice Date
	 */
	@Getter
	@Setter
	private Timestamp invoiceDate;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Paid Date
	 */
	@Getter
	@Setter
	private Timestamp paidDate;
	/**
	 * Reference Number
	 */
	@Getter
	@Setter
	private String referenceNumber;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Message
	 */
	@Getter
	@Setter
	private String invoiceMessage;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public InvoiceAndType(GenericValue value) {
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		invoiceTypeDesc = (String) value.get(FIELD_INVOICE_TYPE_DESC);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		invoiceTypeId = (String) value.get(FIELD_INVOICE_TYPE_ID);
		dueDate = (Timestamp) value.get(FIELD_DUE_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		invoiceDate = (Timestamp) value.get(FIELD_INVOICE_DATE);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		paidDate = (Timestamp) value.get(FIELD_PAID_DATE);
		referenceNumber = (String) value.get(FIELD_REFERENCE_NUMBER);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceMessage = (String) value.get(FIELD_INVOICE_MESSAGE);
		partyId = (String) value.get(FIELD_PARTY_ID);
	}

	public static InvoiceAndType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceAndType(value);
	}

	public static List<InvoiceAndType> fromValues(List<GenericValue> values) {
		List<InvoiceAndType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceAndType(value));
		}
		return entities;
	}
}