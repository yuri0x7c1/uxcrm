package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Billing
 */
public class ReturnItemBilling implements Serializable {

	public static final long serialVersionUID = 6509643288678681600L;
	public static final String NAME = "ReturnItemBilling";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
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
		returnId, returnItemSeqId, invoiceId, invoiceItemSeqId, shipmentReceiptId, quantity, amount
	}

	public ReturnItemBilling(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		shipmentReceiptId = (String) value.get(Fields.shipmentReceiptId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
	}

	public static ReturnItemBilling fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemBilling(value);
	}

	public static List<ReturnItemBilling> fromValues(List<GenericValue> values) {
		List<ReturnItemBilling> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemBilling(value));
		}
		return entities;
	}
}