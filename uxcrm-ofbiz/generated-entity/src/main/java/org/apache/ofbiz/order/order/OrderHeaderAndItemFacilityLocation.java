package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header And Item Facility Location
 */
@FieldNameConstants
public class OrderHeaderAndItemFacilityLocation implements Serializable {

	public static final long serialVersionUID = 5404404704520617984L;
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

	public OrderHeaderAndItemFacilityLocation(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		locationTypeEnumId = (String) value.get(FIELD_LOCATION_TYPE_ENUM_ID);
		areaId = (String) value.get(FIELD_AREA_ID);
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