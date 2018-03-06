package org.apache.ofbiz.shipment.picklist.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist And Bin And Item
 */
public class PicklistAndBinAndItem implements Serializable {

	public static final long serialVersionUID = 444776730142714880L;
	public static final String NAME = "PicklistAndBinAndItem";
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Picklist Date
	 */
	@Getter
	@Setter
	private Timestamp picklistDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Bin Location Number
	 */
	@Getter
	@Setter
	private Long binLocationNumber;
	/**
	 * Primary Order Id
	 */
	@Getter
	@Setter
	private String primaryOrderId;
	/**
	 * Primary Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String primaryShipGroupSeqId;
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
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Item Status Id
	 */
	@Getter
	@Setter
	private String itemStatusId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public enum Fields {
		picklistId, description, facilityId, shipmentMethodTypeId, statusId, picklistDate, createdByUserLogin, lastModifiedByUserLogin, picklistBinId, binLocationNumber, primaryOrderId, primaryShipGroupSeqId, orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId, itemStatusId, quantity
	}

	public PicklistAndBinAndItem(GenericValue value) {
		picklistId = (String) value.get(Fields.picklistId.name());
		description = (String) value.get(Fields.description.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		picklistDate = (Timestamp) value.get(Fields.picklistDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		binLocationNumber = (Long) value.get(Fields.binLocationNumber.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
	}

	public static PicklistAndBinAndItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PicklistAndBinAndItem(value);
	}

	public static List<PicklistAndBinAndItem> fromValues(
			List<GenericValue> values) {
		List<PicklistAndBinAndItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PicklistAndBinAndItem(value));
		}
		return entities;
	}
}