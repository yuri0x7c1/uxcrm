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
 * Invoice Item Category Summary
 */
public class InvoiceItemCategorySummary implements Serializable {

	public static final long serialVersionUID = 8741989614350687232L;
	public static final String NAME = "InvoiceItemCategorySummary";
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
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;

	public enum Fields {
		statusId, invoiceDate, invoiceTypeId, partyIdFrom, partyId, currencyUomId, invoiceItemTypeId, productId, quantityTotal, amountTotal, productCategoryId
	}

	public InvoiceItemCategorySummary(GenericValue value) {
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
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
	}

	public static InvoiceItemCategorySummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemCategorySummary(value);
	}

	public static List<InvoiceItemCategorySummary> fromValues(
			List<GenericValue> values) {
		List<InvoiceItemCategorySummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemCategorySummary(value));
		}
		return entities;
	}
}