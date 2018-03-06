package org.apache.ofbiz.bi.starschema.order.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Order Item Star Schema
 */
public class SalesOrderItemStarSchema implements Serializable {

	public static final long serialVersionUID = 4647905694004800512L;
	public static final String NAME = "SalesOrderItemStarSchema";
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
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Order Date Dim Id
	 */
	@Getter
	@Setter
	private String orderDateDimId;
	/**
	 * Product Dim Id
	 */
	@Getter
	@Setter
	private String productDimId;
	/**
	 * Orig Currency Dim Id
	 */
	@Getter
	@Setter
	private String origCurrencyDimId;
	/**
	 * Bill To Customer Dim Id
	 */
	@Getter
	@Setter
	private String billToCustomerDimId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Brand
	 */
	@Getter
	@Setter
	private String brand;
	/**
	 * Pod
	 */
	@Getter
	@Setter
	private String pod;
	/**
	 * Account
	 */
	@Getter
	@Setter
	private String account;
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
	 * Ext Gross Cost
	 */
	@Getter
	@Setter
	private BigDecimal extGrossCost;
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
	 * Ext Shipping Amount
	 */
	@Getter
	@Setter
	private BigDecimal extShippingAmount;
	/**
	 * Ext Tax Amount
	 */
	@Getter
	@Setter
	private BigDecimal extTaxAmount;
	/**
	 * Gs
	 */
	@Getter
	@Setter
	private BigDecimal GS;
	/**
	 * Gms
	 */
	@Getter
	@Setter
	private BigDecimal GMS;
	/**
	 * Gmp
	 */
	@Getter
	@Setter
	private BigDecimal GMP;
	/**
	 * Gss
	 */
	@Getter
	@Setter
	private BigDecimal GSS;
	/**
	 * Gsc
	 */
	@Getter
	@Setter
	private BigDecimal GSC;
	/**
	 * Gsp
	 */
	@Getter
	@Setter
	private BigDecimal GSP;
	/**
	 * Gp
	 */
	@Getter
	@Setter
	private BigDecimal GP;
	/**
	 * Count Order
	 */
	@Getter
	@Setter
	private BigDecimal countOrder;
	/**
	 * Product Promo Code
	 */
	@Getter
	@Setter
	private String productPromoCode;

	public enum Fields {
		dimensionId, dateValue, description, dayName, dayOfMonth, dayOfYear, monthName, monthOfYear, yearName, weekOfMonth, weekOfYear, yearMonthDay, yearAndMonth, weekdayType, productId, productType, brandName, internalName, currencyId, orderId, orderItemSeqId, orderDateDimId, productDimId, origCurrencyDimId, billToCustomerDimId, productCategoryId, productStoreId, salesChannelEnumId, statusId, brand, pod, account, quantity, extGrossAmount, extGrossCost, extDiscountAmount, extNetAmount, extShippingAmount, extTaxAmount, GS, GMS, GMP, GSS, GSC, GSP, GP, countOrder, productPromoCode
	}

	public SalesOrderItemStarSchema(GenericValue value) {
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
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		orderDateDimId = (String) value.get(Fields.orderDateDimId.name());
		productDimId = (String) value.get(Fields.productDimId.name());
		origCurrencyDimId = (String) value.get(Fields.origCurrencyDimId.name());
		billToCustomerDimId = (String) value.get(Fields.billToCustomerDimId
				.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		brand = (String) value.get(Fields.brand.name());
		pod = (String) value.get(Fields.pod.name());
		account = (String) value.get(Fields.account.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		extGrossAmount = (BigDecimal) value.get(Fields.extGrossAmount.name());
		extGrossCost = (BigDecimal) value.get(Fields.extGrossCost.name());
		extDiscountAmount = (BigDecimal) value.get(Fields.extDiscountAmount
				.name());
		extNetAmount = (BigDecimal) value.get(Fields.extNetAmount.name());
		extShippingAmount = (BigDecimal) value.get(Fields.extShippingAmount
				.name());
		extTaxAmount = (BigDecimal) value.get(Fields.extTaxAmount.name());
		GS = (BigDecimal) value.get(Fields.GS.name());
		GMS = (BigDecimal) value.get(Fields.GMS.name());
		GMP = (BigDecimal) value.get(Fields.GMP.name());
		GSS = (BigDecimal) value.get(Fields.GSS.name());
		GSC = (BigDecimal) value.get(Fields.GSC.name());
		GSP = (BigDecimal) value.get(Fields.GSP.name());
		GP = (BigDecimal) value.get(Fields.GP.name());
		countOrder = (BigDecimal) value.get(Fields.countOrder.name());
		productPromoCode = (String) value.get(Fields.productPromoCode.name());
	}

	public static SalesOrderItemStarSchema fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOrderItemStarSchema(value);
	}

	public static List<SalesOrderItemStarSchema> fromValues(
			List<GenericValue> values) {
		List<SalesOrderItemStarSchema> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOrderItemStarSchema(value));
		}
		return entities;
	}
}