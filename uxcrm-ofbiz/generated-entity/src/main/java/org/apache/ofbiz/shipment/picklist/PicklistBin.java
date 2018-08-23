package org.apache.ofbiz.shipment.picklist;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist Bin
 */
@FieldNameConstants
public class PicklistBin implements Serializable {

	public static final long serialVersionUID = 5553305747791385600L;
	public static final String NAME = "PicklistBin";
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
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

	public PicklistBin(GenericValue value) {
		picklistBinId = (String) value.get(FIELD_PICKLIST_BIN_ID);
		picklistId = (String) value.get(FIELD_PICKLIST_ID);
		binLocationNumber = (Long) value.get(FIELD_BIN_LOCATION_NUMBER);
		primaryOrderId = (String) value.get(FIELD_PRIMARY_ORDER_ID);
		primaryShipGroupSeqId = (String) value
				.get(FIELD_PRIMARY_SHIP_GROUP_SEQ_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PicklistBin fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PicklistBin(value);
	}

	public static List<PicklistBin> fromValues(List<GenericValue> values) {
		List<PicklistBin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PicklistBin(value));
		}
		return entities;
	}
}