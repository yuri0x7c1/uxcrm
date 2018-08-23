package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Billing
 */
@FieldNameConstants
public class OrderItemBilling implements Serializable {

	public static final long serialVersionUID = 4133201159852279808L;
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

	public OrderItemBilling(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		shipmentReceiptId = (String) value.get(FIELD_SHIPMENT_RECEIPT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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