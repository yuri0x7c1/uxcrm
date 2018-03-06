package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Item
 */
public class ShipmentItem implements Serializable {

	public static final long serialVersionUID = 4645741263411406848L;
	public static final String NAME = "ShipmentItem";
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
	 * Shipment Content Description
	 */
	@Getter
	@Setter
	private String shipmentContentDescription;

	public enum Fields {
		shipmentId, shipmentItemSeqId, productId, quantity, shipmentContentDescription
	}

	public ShipmentItem(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		shipmentContentDescription = (String) value
				.get(Fields.shipmentContentDescription.name());
	}

	public static ShipmentItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentItem(value);
	}

	public static List<ShipmentItem> fromValues(List<GenericValue> values) {
		List<ShipmentItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentItem(value));
		}
		return entities;
	}
}