package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header And Item Facility Location
 */
public class OrderHeaderAndItemFacilityLocation implements Serializable {

	public static final long serialVersionUID = 7846036461205645312L;
	public static final String NAME = "OrderHeaderAndItemFacilityLocation";
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
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Location Type Enum Id
	 */
	@Getter
	@Setter
	private String locationTypeEnumId;
	/**
	 * Area Id
	 */
	@Getter
	@Setter
	private String areaId;

	public enum Fields {
		orderId, orderItemSeqId, inventoryItemId, shipGroupSeqId, shipmentMethodTypeId, carrierPartyId, productId, facilityId, locationSeqId, locationTypeEnumId, areaId
	}

	public OrderHeaderAndItemFacilityLocation(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
		areaId = (String) value.get(Fields.areaId.name());
	}

	public static OrderHeaderAndItemFacilityLocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndItemFacilityLocation(value);
	}

	public static List<OrderHeaderAndItemFacilityLocation> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderAndItemFacilityLocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndItemFacilityLocation(value));
		}
		return entities;
	}
}