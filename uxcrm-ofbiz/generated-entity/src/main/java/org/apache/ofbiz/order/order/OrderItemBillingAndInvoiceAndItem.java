package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderItemBillingAndInvoiceAndItem implements Serializable {

	public static final long serialVersionUID = 5266550895847836672L;
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

	public OrderItemBillingAndInvoiceAndItem(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		orderId = (String) value.get(FIELD_ORDER_ID);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		shipmentReceiptId = (String) value.get(FIELD_SHIPMENT_RECEIPT_ID);
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