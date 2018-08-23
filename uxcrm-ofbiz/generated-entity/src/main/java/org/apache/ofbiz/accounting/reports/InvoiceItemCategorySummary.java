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
 * Invoice Item Category Summary
 */
@FieldNameConstants
public class InvoiceItemCategorySummary implements Serializable {

	public static final long serialVersionUID = 7977063103394381824L;
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

	public InvoiceItemCategorySummary(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		invoiceDate = (Timestamp) value.get(FIELD_INVOICE_DATE);
		invoiceTypeId = (String) value.get(FIELD_INVOICE_TYPE_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyId = (String) value.get(FIELD_PARTY_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantityTotal = (BigDecimal) value.get(FIELD_QUANTITY_TOTAL);
		amountTotal = (BigDecimal) value.get(FIELD_AMOUNT_TOTAL);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
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