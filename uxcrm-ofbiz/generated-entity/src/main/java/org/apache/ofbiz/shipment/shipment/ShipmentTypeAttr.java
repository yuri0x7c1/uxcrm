package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Type Attr
 */
public class ShipmentTypeAttr implements Serializable {

	public static final long serialVersionUID = 5113248101994883072L;
	public static final String NAME = "ShipmentTypeAttr";
	/**
	 * Shipment Type Id
	 */
	@Getter
	@Setter
	private String shipmentTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		shipmentTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentTypeAttr(GenericValue value) {
		shipmentTypeId = (String) value.get(Fields.shipmentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentTypeAttr(value);
	}

	public static List<ShipmentTypeAttr> fromValues(List<GenericValue> values) {
		List<ShipmentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentTypeAttr(value));
		}
		return entities;
	}
}