package org.apache.ofbiz.order.order;

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
public class OrderHeaderAndItems implements Serializable {

	public static final long serialVersionUID = 1361133429225674752L;
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

	public enum Fields {
		orderId, orderDate, orderStatusId, grandTotal, productStoreId, orderTypeId, orderItemSeqId, productId, quantity, cancelQuantity, unitPrice, unitListPrice, itemDescription, itemStatusId, estimatedShipDate, estimatedDeliveryDate, shipBeforeDate, shipAfterDate, orderItemTypeId
	}

	public OrderHeaderAndItems(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
		unitListPrice = (BigDecimal) value.get(Fields.unitListPrice.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		estimatedDeliveryDate = (Timestamp) value
				.get(Fields.estimatedDeliveryDate.name());
		shipBeforeDate = (Timestamp) value.get(Fields.shipBeforeDate.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		orderItemTypeId = (String) value.get(Fields.orderItemTypeId.name());
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