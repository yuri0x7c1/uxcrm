package org.apache.ofbiz.shipment.shipment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Packed Qty Vs Order Item Quantity
 */
public class PackedQtyVsOrderItemQuantity implements Serializable {

	public static final long serialVersionUID = 7184370765827917824L;
	public static final String NAME = "PackedQtyVsOrderItemQuantity";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
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
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;

	public enum Fields {
		shipmentId, shipmentPackageSeqId, quantity, orderId, orderItemSeqId
	}

	public PackedQtyVsOrderItemQuantity(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
	}

	public static PackedQtyVsOrderItemQuantity fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PackedQtyVsOrderItemQuantity(value);
	}

	public static List<PackedQtyVsOrderItemQuantity> fromValues(
			List<GenericValue> values) {
		List<PackedQtyVsOrderItemQuantity> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PackedQtyVsOrderItemQuantity(value));
		}
		return entities;
	}
}