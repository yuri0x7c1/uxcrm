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
 * Order Adjustment Billing
 */
@FieldNameConstants
public class OrderAdjustmentBilling implements Serializable {

	public static final long serialVersionUID = 7026430626705418240L;
	public static final String NAME = "OrderAdjustmentBilling";
	/**
	 * Order Adjustment Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentId;
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

	public OrderAdjustmentBilling(GenericValue value) {
		orderAdjustmentId = (String) value.get(FIELD_ORDER_ADJUSTMENT_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderAdjustmentBilling fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAdjustmentBilling(value);
	}

	public static List<OrderAdjustmentBilling> fromValues(
			List<GenericValue> values) {
		List<OrderAdjustmentBilling> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAdjustmentBilling(value));
		}
		return entities;
	}
}