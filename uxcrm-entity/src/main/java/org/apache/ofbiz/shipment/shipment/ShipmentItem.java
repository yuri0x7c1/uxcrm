package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Item
 */
public class ShipmentItem implements Serializable {

	public static final long serialVersionUID = 4903160261784079360L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		shipmentId, shipmentItemSeqId, productId, quantity, shipmentContentDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentItem(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		shipmentContentDescription = (String) value
				.get(Fields.shipmentContentDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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