package org.apache.ofbiz.shipment.receipt;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShipmentReceiptRole implements Serializable {

	public static final long serialVersionUID = 1208076611815979008L;
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

	public ShipmentReceiptRole(GenericValue value) {
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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