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
 * Shipment Package Content
 */
public class ShipmentPackageContent implements Serializable {

	public static final long serialVersionUID = 4660262272461940736L;
	public static final String NAME = "ShipmentPackageContent";
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
	/**
	 * Sub Product Id
	 */
	@Getter
	@Setter
	private String subProductId;
	/**
	 * Sub Product Quantity
	 */
	@Getter
	@Setter
	private BigDecimal subProductQuantity;
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
		shipmentId, shipmentPackageSeqId, shipmentItemSeqId, quantity, subProductId, subProductQuantity, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentPackageContent(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		subProductId = (String) value.get(Fields.subProductId.name());
		subProductQuantity = (BigDecimal) value.get(Fields.subProductQuantity
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentPackageContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentPackageContent(value);
	}

	public static List<ShipmentPackageContent> fromValues(
			List<GenericValue> values) {
		List<ShipmentPackageContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentPackageContent(value));
		}
		return entities;
	}
}