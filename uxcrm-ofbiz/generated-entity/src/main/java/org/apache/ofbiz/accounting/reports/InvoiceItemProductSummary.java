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
 * Invoice Item Product Summary
 */
public class InvoiceItemProductSummary implements Serializable {

	public static final long serialVersionUID = 157281034746811392L;
	public static final String NAME = "InvoiceItemProductSummary";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityTotal;
	/**
	 * Amount Total
	 */
	@Getter
	@Setter
	private BigDecimal amountTotal;

	public enum Fields {
		statusId, invoiceDate, invoiceTypeId, partyIdFrom, partyId, currencyUomId, invoiceItemTypeId, productId, quantityTotal, amountTotal
	}

	public InvoiceItemProductSummary(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		invoiceDate = (Timestamp) value.get(Fields.invoiceDate.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyId = (String) value.get(Fields.partyId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		productId = (String) value.get(Fields.productId.name());
		quantityTotal = (BigDecimal) value.get(Fields.quantityTotal.name());
		amountTotal = (BigDecimal) value.get(Fields.amountTotal.name());
	}

	public static InvoiceItemProductSummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemProductSummary(value);
	}

	public static List<InvoiceItemProductSummary> fromValues(
			List<GenericValue> values) {
		List<InvoiceItemProductSummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemProductSummary(value));
		}
		return entities;
	}
}