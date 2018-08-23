package org.apache.ofbiz.order.order;

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
 * Order Header And Items
 */
@FieldNameConstants
public class OrderHeaderAndItems implements Serializable {

	public static final long serialVersionUID = 3253371637499315200L;
	public static final String NAME = "OrderHeaderAndItems";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Order Status Id
	 */
	@Getter
	@Setter
	private String orderStatusId;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	/**
	 * Unit List Price
	 */
	@Getter
	@Setter
	private BigDecimal unitListPrice;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Item Status Id
	 */
	@Getter
	@Setter
	private String itemStatusId;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedDeliveryDate;
	/**
	 * Ship Before Date
	 */
	@Getter
	@Setter
	private Timestamp shipBeforeDate;
	/**
	 * Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp shipAfterDate;
	/**
	 * Order Item Type Id
	 */
	@Getter
	@Setter
	private String orderItemTypeId;

	public OrderHeaderAndItems(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		unitListPrice = (BigDecimal) value.get(FIELD_UNIT_LIST_PRICE);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		itemStatusId = (String) value.get(FIELD_ITEM_STATUS_ID);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		shipBeforeDate = (Timestamp) value.get(FIELD_SHIP_BEFORE_DATE);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		orderItemTypeId = (String) value.get(FIELD_ORDER_ITEM_TYPE_ID);
	}

	public static OrderHeaderAndItems fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndItems(value);
	}

	public static List<OrderHeaderAndItems> fromValues(List<GenericValue> values) {
		List<OrderHeaderAndItems> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndItems(value));
		}
		return entities;
	}
}