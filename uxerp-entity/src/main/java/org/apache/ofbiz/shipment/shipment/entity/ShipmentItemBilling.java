package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Item Billing
 */
public class ShipmentItemBilling implements Serializable {

	public static final long serialVersionUID = 1808474751221195776L;
	public static final String NAME = "ShipmentItemBilling";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
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

	public enum Fields {
		shipmentId, shipmentItemSeqId, invoiceId, invoiceItemSeqId
	}

	public ShipmentItemBilling(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
	}

	public static ShipmentItemBilling fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentItemBilling(value);
	}

	public static List<ShipmentItemBilling> fromValues(List<GenericValue> values) {
		List<ShipmentItemBilling> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentItemBilling(value));
		}
		return entities;
	}
}