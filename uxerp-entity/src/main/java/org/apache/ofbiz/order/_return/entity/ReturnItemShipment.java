package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Shipment
 */
public class ReturnItemShipment implements Serializable {

	public static final long serialVersionUID = 7606991742274499584L;
	public static final String NAME = "ReturnItemShipment";
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
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public enum Fields {
		returnId, returnItemSeqId, shipmentId, shipmentItemSeqId, quantity
	}

	public ReturnItemShipment(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
	}

	public static ReturnItemShipment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemShipment(value);
	}

	public static List<ReturnItemShipment> fromValues(List<GenericValue> values) {
		List<ReturnItemShipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemShipment(value));
		}
		return entities;
	}
}