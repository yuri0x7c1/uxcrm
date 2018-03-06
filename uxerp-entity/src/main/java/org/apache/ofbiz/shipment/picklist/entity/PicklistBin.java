package org.apache.ofbiz.shipment.picklist.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist Bin
 */
public class PicklistBin implements Serializable {

	public static final long serialVersionUID = 5010683411900669952L;
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

	public enum Fields {
		picklistBinId, picklistId, binLocationNumber, primaryOrderId, primaryShipGroupSeqId
	}

	public PicklistBin(GenericValue value) {
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		picklistId = (String) value.get(Fields.picklistId.name());
		binLocationNumber = (Long) value.get(Fields.binLocationNumber.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
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