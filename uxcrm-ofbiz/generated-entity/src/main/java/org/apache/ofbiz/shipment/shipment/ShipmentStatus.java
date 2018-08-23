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
 * Shipment Status
 */
@FieldNameConstants
public class ShipmentStatus implements Serializable {

	public static final long serialVersionUID = 8153589021283104768L;
	public static final String NAME = "ShipmentStatus";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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

	public ShipmentStatus(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentStatus(value);
	}

	public static List<ShipmentStatus> fromValues(List<GenericValue> values) {
		List<ShipmentStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentStatus(value));
		}
		return entities;
	}
}