package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Attribute
 */
@FieldNameConstants
public class ShipmentAttribute implements Serializable {

	public static final long serialVersionUID = 3905619312987499520L;
	public static final String NAME = "ShipmentAttribute";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public ShipmentAttribute(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentAttribute(value);
	}

	public static List<ShipmentAttribute> fromValues(List<GenericValue> values) {
		List<ShipmentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentAttribute(value));
		}
		return entities;
	}
}