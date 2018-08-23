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
 * Shipment Type Attr
 */
@FieldNameConstants
public class ShipmentTypeAttr implements Serializable {

	public static final long serialVersionUID = 6609306944541883392L;
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

	public ShipmentTypeAttr(GenericValue value) {
		shipmentTypeId = (String) value.get(FIELD_SHIPMENT_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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