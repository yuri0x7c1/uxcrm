package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PackedQtyVsOrderItemQuantity implements Serializable {

	public static final long serialVersionUID = 8699037456868701184L;
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

	public PackedQtyVsOrderItemQuantity(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		packedQuantity = (BigDecimal) value.get(FIELD_PACKED_QUANTITY);
		issuedQuantity = (BigDecimal) value.get(FIELD_ISSUED_QUANTITY);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		orderedQuantity = (BigDecimal) value.get(FIELD_ORDERED_QUANTITY);
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