package org.apache.ofbiz.accounting.reports;

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
 * Invoice Export
 */
@FieldNameConstants
public class InvoiceExport implements Serializable {

	public static final long serialVersionUID = 8221585911644965888L;
	public static final String NAME = "InvoiceExport";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Date
	 */
	@Getter
	@Setter
	private Timestamp invoiceDate;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id From Trans
	 */
	@Getter
	@Setter
	private String partyIdFromTrans;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Id Trans
	 */
	@Getter
	@Setter
	private String partyIdTrans;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Reference Number
	 */
	@Getter
	@Setter
	private String referenceNumber;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Id Trans
	 */
	@Getter
	@Setter
	private String productIdTrans;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public InvoiceExport(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceDate = (Timestamp) value.get(FIELD_INVOICE_DATE);
		invoiceTypeId = (String) value.get(FIELD_INVOICE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdFromTrans = (String) value.get(FIELD_PARTY_ID_FROM_TRANS);
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyIdTrans = (String) value.get(FIELD_PARTY_ID_TRANS);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		referenceNumber = (String) value.get(FIELD_REFERENCE_NUMBER);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productIdTrans = (String) value.get(FIELD_PRODUCT_ID_TRANS);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
	}

	public static InvoiceExport fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceExport(value);
	}

	public static List<InvoiceExport> fromValues(List<GenericValue> values) {
		List<InvoiceExport> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceExport(value));
		}
		return entities;
	}
}