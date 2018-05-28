package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Billing And Invoice And Item
 */
public class OrderItemBillingAndInvoiceAndItem implements Serializable {

	public static final long serialVersionUID = 5249120595652536320L;
	public static final String NAME = "OrderItemBillingAndInvoiceAndItem";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
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
	 * Shipment Receipt Id
	 */
	@Getter
	@Setter
	private String shipmentReceiptId;

	public enum Fields {
		statusId, orderItemSeqId, amount, quantity, orderId, itemIssuanceId, invoiceId, invoiceItemSeqId, shipmentReceiptId
	}

	public OrderItemBillingAndInvoiceAndItem(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		shipmentReceiptId = (String) value.get(Fields.shipmentReceiptId.name());
	}

	public static OrderItemBillingAndInvoiceAndItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemBillingAndInvoiceAndItem(value);
	}

	public static List<OrderItemBillingAndInvoiceAndItem> fromValues(
			List<GenericValue> values) {
		List<OrderItemBillingAndInvoiceAndItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemBillingAndInvoiceAndItem(value));
		}
		return entities;
	}
}