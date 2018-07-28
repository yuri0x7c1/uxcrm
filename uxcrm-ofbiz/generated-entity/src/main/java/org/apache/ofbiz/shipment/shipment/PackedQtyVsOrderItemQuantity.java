package org.apache.ofbiz.shipment.shipment;

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

	public static final long serialVersionUID = 1009188338919587840L;
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
	 * Packed Quantity
	 */
	@Getter
	@Setter
	private BigDecimal packedQuantity;
	/**
	 * Issued Quantity
	 */
	@Getter
	@Setter
	private BigDecimal issuedQuantity;
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
	 * Ordered Quantity
	 */
	@Getter
	@Setter
	private BigDecimal orderedQuantity;

	public enum Fields {
		shipmentId, shipmentPackageSeqId, packedQuantity, issuedQuantity, orderId, orderItemSeqId, orderedQuantity
	}

	public PackedQtyVsOrderItemQuantity(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		packedQuantity = (BigDecimal) value.get(Fields.packedQuantity.name());
		issuedQuantity = (BigDecimal) value.get(Fields.issuedQuantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		orderedQuantity = (BigDecimal) value.get(Fields.orderedQuantity.name());
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