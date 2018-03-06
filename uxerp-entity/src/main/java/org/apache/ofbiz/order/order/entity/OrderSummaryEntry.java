package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Summary Entry
 */
public class OrderSummaryEntry implements Serializable {

	public static final long serialVersionUID = 8350026921375683584L;
	public static final String NAME = "OrderSummaryEntry";
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Date entryDate;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Total Quantity
	 */
	@Getter
	@Setter
	private BigDecimal totalQuantity;
	/**
	 * Gross Sales
	 */
	@Getter
	@Setter
	private BigDecimal grossSales;
	/**
	 * Product Cost
	 */
	@Getter
	@Setter
	private BigDecimal productCost;

	public enum Fields {
		entryDate, productId, facilityId, totalQuantity, grossSales, productCost
	}

	public OrderSummaryEntry(GenericValue value) {
		entryDate = (Date) value.get(Fields.entryDate.name());
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		totalQuantity = (BigDecimal) value.get(Fields.totalQuantity.name());
		grossSales = (BigDecimal) value.get(Fields.grossSales.name());
		productCost = (BigDecimal) value.get(Fields.productCost.name());
	}

	public static OrderSummaryEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderSummaryEntry(value);
	}

	public static List<OrderSummaryEntry> fromValues(List<GenericValue> values) {
		List<OrderSummaryEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderSummaryEntry(value));
		}
		return entities;
	}
}