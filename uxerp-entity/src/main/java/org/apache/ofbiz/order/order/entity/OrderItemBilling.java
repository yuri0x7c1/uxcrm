package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Billing
 */
public class OrderItemBilling implements Serializable {

	public static final long serialVersionUID = 3164613698542139392L;
	public static final String NAME = "OrderItemBilling";
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
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
	/**
	 * Shipment Receipt Id
	 */
	@Getter
	@Setter
	private String shipmentReceiptId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public enum Fields {
		orderId, orderItemSeqId, invoiceId, invoiceItemSeqId, itemIssuanceId, shipmentReceiptId, quantity, amount
	}

	public OrderItemBilling(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		shipmentReceiptId = (String) value.get(Fields.shipmentReceiptId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
	}

	public static OrderItemBilling fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemBilling(value);
	}

	public static List<OrderItemBilling> fromValues(List<GenericValue> values) {
		List<OrderItemBilling> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemBilling(value));
		}
		return entities;
	}
}