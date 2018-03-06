package org.apache.ofbiz.bi.starschema.accounting.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Invoice Item Star Schema
 */
public class SalesInvoiceItemStarSchema implements Serializable {

	public static final long serialVersionUID = 7065765840987121664L;
	public static final String NAME = "SalesInvoiceItemStarSchema";
	/**
	 * Dimension Id
	 */
	@Getter
	@Setter
	private String dimensionId;
	/**
	 * Date Value
	 */
	@Getter
	@Setter
	private Date dateValue;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Day Name
	 */
	@Getter
	@Setter
	private String dayName;
	/**
	 * Day Of Month
	 */
	@Getter
	@Setter
	private Long dayOfMonth;
	/**
	 * Day Of Year
	 */
	@Getter
	@Setter
	private Long dayOfYear;
	/**
	 * Month Name
	 */
	@Getter
	@Setter
	private String monthName;
	/**
	 * Month Of Year
	 */
	@Getter
	@Setter
	private Long monthOfYear;
	/**
	 * Year Name
	 */
	@Getter
	@Setter
	private Long yearName;
	/**
	 * Week Of Month
	 */
	@Getter
	@Setter
	private Long weekOfMonth;
	/**
	 * Week Of Year
	 */
	@Getter
	@Setter
	private Long weekOfYear;
	/**
	 * Year Month Day
	 */
	@Getter
	@Setter
	private String yearMonthDay;
	/**
	 * Year And Month
	 */
	@Getter
	@Setter
	private String yearAndMonth;
	/**
	 * Weekday Type
	 */
	@Getter
	@Setter
	private String weekdayType;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Type
	 */
	@Getter
	@Setter
	private String productType;
	/**
	 * Brand Name
	 */
	@Getter
	@Setter
	private String brandName;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Currency Id
	 */
	@Getter
	@Setter
	private String currencyId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Invoice Date Dim Id
	 */
	@Getter
	@Setter
	private String invoiceDateDimId;
	/**
	 * Product Dim Id
	 */
	@Getter
	@Setter
	private String productDimId;
	/**
	 * Bill To Customer Dim Id
	 */
	@Getter
	@Setter
	private String billToCustomerDimId;
	/**
	 * Orig Currency Dim Id
	 */
	@Getter
	@Setter
	private String origCurrencyDimId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Ext Gross Amount
	 */
	@Getter
	@Setter
	private BigDecimal extGrossAmount;
	/**
	 * Ext Discount Amount
	 */
	@Getter
	@Setter
	private BigDecimal extDiscountAmount;
	/**
	 * Ext Net Amount
	 */
	@Getter
	@Setter
	private BigDecimal extNetAmount;
	/**
	 * Ext Tax Amount
	 */
	@Getter
	@Setter
	private BigDecimal extTaxAmount;
	/**
	 * Ext Man Fixed Cost
	 */
	@Getter
	@Setter
	private BigDecimal extManFixedCost;
	/**
	 * Ext Man Var Cost
	 */
	@Getter
	@Setter
	private BigDecimal extManVarCost;
	/**
	 * Ext Storage Cost
	 */
	@Getter
	@Setter
	private BigDecimal extStorageCost;
	/**
	 * Ext Distribution Cost
	 */
	@Getter
	@Setter
	private BigDecimal extDistributionCost;
	/**
	 * Contribution Amount
	 */
	@Getter
	@Setter
	private BigDecimal contributionAmount;

	public enum Fields {
		dimensionId, dateValue, description, dayName, dayOfMonth, dayOfYear, monthName, monthOfYear, yearName, weekOfMonth, weekOfYear, yearMonthDay, yearAndMonth, weekdayType, productId, productType, brandName, internalName, currencyId, invoiceId, invoiceItemSeqId, orderId, invoiceDateDimId, productDimId, billToCustomerDimId, origCurrencyDimId, quantity, extGrossAmount, extDiscountAmount, extNetAmount, extTaxAmount, extManFixedCost, extManVarCost, extStorageCost, extDistributionCost, contributionAmount
	}

	public SalesInvoiceItemStarSchema(GenericValue value) {
		dimensionId = (String) value.get(Fields.dimensionId.name());
		dateValue = (Date) value.get(Fields.dateValue.name());
		description = (String) value.get(Fields.description.name());
		dayName = (String) value.get(Fields.dayName.name());
		dayOfMonth = (Long) value.get(Fields.dayOfMonth.name());
		dayOfYear = (Long) value.get(Fields.dayOfYear.name());
		monthName = (String) value.get(Fields.monthName.name());
		monthOfYear = (Long) value.get(Fields.monthOfYear.name());
		yearName = (Long) value.get(Fields.yearName.name());
		weekOfMonth = (Long) value.get(Fields.weekOfMonth.name());
		weekOfYear = (Long) value.get(Fields.weekOfYear.name());
		yearMonthDay = (String) value.get(Fields.yearMonthDay.name());
		yearAndMonth = (String) value.get(Fields.yearAndMonth.name());
		weekdayType = (String) value.get(Fields.weekdayType.name());
		productId = (String) value.get(Fields.productId.name());
		productType = (String) value.get(Fields.productType.name());
		brandName = (String) value.get(Fields.brandName.name());
		internalName = (String) value.get(Fields.internalName.name());
		currencyId = (String) value.get(Fields.currencyId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		orderId = (String) value.get(Fields.orderId.name());
		invoiceDateDimId = (String) value.get(Fields.invoiceDateDimId.name());
		productDimId = (String) value.get(Fields.productDimId.name());
		billToCustomerDimId = (String) value.get(Fields.billToCustomerDimId
				.name());
		origCurrencyDimId = (String) value.get(Fields.origCurrencyDimId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		extGrossAmount = (BigDecimal) value.get(Fields.extGrossAmount.name());
		extDiscountAmount = (BigDecimal) value.get(Fields.extDiscountAmount
				.name());
		extNetAmount = (BigDecimal) value.get(Fields.extNetAmount.name());
		extTaxAmount = (BigDecimal) value.get(Fields.extTaxAmount.name());
		extManFixedCost = (BigDecimal) value.get(Fields.extManFixedCost.name());
		extManVarCost = (BigDecimal) value.get(Fields.extManVarCost.name());
		extStorageCost = (BigDecimal) value.get(Fields.extStorageCost.name());
		extDistributionCost = (BigDecimal) value.get(Fields.extDistributionCost
				.name());
		contributionAmount = (BigDecimal) value.get(Fields.contributionAmount
				.name());
	}

	public static SalesInvoiceItemStarSchema fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesInvoiceItemStarSchema(value);
	}

	public static List<SalesInvoiceItemStarSchema> fromValues(
			List<GenericValue> values) {
		List<SalesInvoiceItemStarSchema> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesInvoiceItemStarSchema(value));
		}
		return entities;
	}
}