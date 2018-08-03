package org.apache.ofbiz.shipment.picklist;

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
public class PicklistBin implements Serializable {

	public static final long serialVersionUID = 2417112827097007104L;
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

	public enum Fields {
		picklistBinId, picklistId, binLocationNumber, primaryOrderId, primaryShipGroupSeqId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PicklistBin(GenericValue value) {
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		picklistId = (String) value.get(Fields.picklistId.name());
		binLocationNumber = (Long) value.get(Fields.binLocationNumber.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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