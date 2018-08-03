package org.apache.ofbiz.accounting.reports;

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
public class InvoiceExport implements Serializable {

	public static final long serialVersionUID = 4017871263794202624L;
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

	public enum Fields {
		invoiceId, invoiceDate, invoiceTypeId, description, partyIdFrom, partyIdFromTrans, partyId, partyIdTrans, currencyUomId, referenceNumber, invoiceItemSeqId, invoiceItemTypeId, itemDescription, productId, productIdTrans, quantity, amount
	}

	public InvoiceExport(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceDate = (Timestamp) value.get(Fields.invoiceDate.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		description = (String) value.get(Fields.description.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdFromTrans = (String) value.get(Fields.partyIdFromTrans.name());
		partyId = (String) value.get(Fields.partyId.name());
		partyIdTrans = (String) value.get(Fields.partyIdTrans.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		referenceNumber = (String) value.get(Fields.referenceNumber.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		productId = (String) value.get(Fields.productId.name());
		productIdTrans = (String) value.get(Fields.productIdTrans.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
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