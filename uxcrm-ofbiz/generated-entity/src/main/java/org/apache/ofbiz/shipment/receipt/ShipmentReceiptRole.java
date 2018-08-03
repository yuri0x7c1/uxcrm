package org.apache.ofbiz.shipment.receipt;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Receipt Role
 */
public class ShipmentReceiptRole implements Serializable {

	public static final long serialVersionUID = 8827243031723220992L;
	public static final String NAME = "ShipmentReceiptRole";
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
		receiptId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentReceiptRole(GenericValue value) {
		receiptId = (String) value.get(Fields.receiptId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentReceiptRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentReceiptRole(value);
	}

	public static List<ShipmentReceiptRole> fromValues(List<GenericValue> values) {
		List<ShipmentReceiptRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentReceiptRole(value));
		}
		return entities;
	}
}