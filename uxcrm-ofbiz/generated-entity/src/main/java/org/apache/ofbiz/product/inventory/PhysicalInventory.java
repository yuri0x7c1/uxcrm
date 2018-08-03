package org.apache.ofbiz.product.inventory;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Physical Inventory
 */
public class PhysicalInventory implements Serializable {

	public static final long serialVersionUID = 1257208048739395584L;
	public static final String NAME = "PhysicalInventory";
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
	/**
	 * Physical Inventory Date
	 */
	@Getter
	@Setter
	private Timestamp physicalInventoryDate;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * General Comments
	 */
	@Getter
	@Setter
	private String generalComments;
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
		physicalInventoryId, physicalInventoryDate, partyId, generalComments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PhysicalInventory(GenericValue value) {
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		physicalInventoryDate = (Timestamp) value
				.get(Fields.physicalInventoryDate.name());
		partyId = (String) value.get(Fields.partyId.name());
		generalComments = (String) value.get(Fields.generalComments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PhysicalInventory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PhysicalInventory(value);
	}

	public static List<PhysicalInventory> fromValues(List<GenericValue> values) {
		List<PhysicalInventory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PhysicalInventory(value));
		}
		return entities;
	}
}