package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Summary Entry
 */
@FieldNameConstants
public class OrderSummaryEntry implements Serializable {

	public static final long serialVersionUID = 8886119787917665280L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public OrderSummaryEntry(GenericValue value) {
		entryDate = (Date) value.get(FIELD_ENTRY_DATE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		totalQuantity = (BigDecimal) value.get(FIELD_TOTAL_QUANTITY);
		grossSales = (BigDecimal) value.get(FIELD_GROSS_SALES);
		productCost = (BigDecimal) value.get(FIELD_PRODUCT_COST);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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