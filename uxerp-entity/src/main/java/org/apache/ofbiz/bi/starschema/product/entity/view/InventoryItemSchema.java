package org.apache.ofbiz.bi.starschema.product.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Schema
 */
public class InventoryItemSchema implements Serializable {

	public static final long serialVersionUID = 5241016720062100480L;
	public static final String NAME = "InventoryItemSchema";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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
	 * Inventory Date Dim Id
	 */
	@Getter
	@Setter
	private String inventoryDateDimId;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Soldout Amount
	 */
	@Getter
	@Setter
	private BigDecimal soldoutAmount;
	/**
	 * Dimension Id
	 */
	@Getter
	@Setter
	private String dimensionId;
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
	 * Currency Id
	 */
	@Getter
	@Setter
	private String currencyId;

	public enum Fields {
		inventoryItemId, facilityId, productDimId, origCurrencyDimId, inventoryDateDimId, quantityOnHandTotal, availableToPromiseTotal, unitCost, soldoutAmount, dimensionId, productId, productType, brandName, internalName, dateValue, description, dayName, dayOfMonth, dayOfYear, monthName, monthOfYear, yearName, weekOfMonth, weekOfYear, yearMonthDay, yearAndMonth, weekdayType, currencyId
	}

	public InventoryItemSchema(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		productDimId = (String) value.get(Fields.productDimId.name());
		origCurrencyDimId = (String) value.get(Fields.origCurrencyDimId.name());
		inventoryDateDimId = (String) value.get(Fields.inventoryDateDimId
				.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		soldoutAmount = (BigDecimal) value.get(Fields.soldoutAmount.name());
		dimensionId = (String) value.get(Fields.dimensionId.name());
		productId = (String) value.get(Fields.productId.name());
		productType = (String) value.get(Fields.productType.name());
		brandName = (String) value.get(Fields.brandName.name());
		internalName = (String) value.get(Fields.internalName.name());
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
		currencyId = (String) value.get(Fields.currencyId.name());
	}

	public static InventoryItemSchema fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemSchema(value);
	}

	public static List<InventoryItemSchema> fromValues(List<GenericValue> values) {
		List<InventoryItemSchema> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemSchema(value));
		}
		return entities;
	}
}