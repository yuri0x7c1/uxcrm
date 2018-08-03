package org.apache.ofbiz.shipment.picklist;

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

	public static final long serialVersionUID = 4875756802889526272L;
	public static final String NAME = "PicklistAndBinAndItem";
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Picklist Date
	 */
	@Getter
	@Setter
	private Timestamp picklistDate;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Primary Order Id
	 */
	@Getter
	@Setter
	private String primaryOrderId;
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Primary Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String primaryShipGroupSeqId;
	/**
	 * Bin Location Number
	 */
	@Getter
	@Setter
	private Long binLocationNumber;
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
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Item Status Id
	 */
	@Getter
	@Setter
	private String itemStatusId;

	public enum Fields {
		picklistId, lastModifiedByUserLogin, facilityId, statusId, description, picklistDate, shipmentMethodTypeId, createdByUserLogin, primaryOrderId, picklistBinId, primaryShipGroupSeqId, binLocationNumber, orderItemSeqId, inventoryItemId, quantity, orderId, shipGroupSeqId, itemStatusId
	}

	public PicklistAndBinAndItem(GenericValue value) {
		picklistId = (String) value.get(Fields.picklistId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		statusId = (String) value.get(Fields.statusId.name());
		description = (String) value.get(Fields.description.name());
		picklistDate = (Timestamp) value.get(Fields.picklistDate.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
		binLocationNumber = (Long) value.get(Fields.binLocationNumber.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
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