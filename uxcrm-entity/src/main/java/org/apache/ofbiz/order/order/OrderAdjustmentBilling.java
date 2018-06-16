package org.apache.ofbiz.order.order;

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
public class OrderAdjustmentBilling implements Serializable {

	public static final long serialVersionUID = 7489354142089664512L;
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

	public enum Fields {
		orderAdjustmentId, invoiceId, invoiceItemSeqId, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderAdjustmentBilling(GenericValue value) {
		orderAdjustmentId = (String) value.get(Fields.orderAdjustmentId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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