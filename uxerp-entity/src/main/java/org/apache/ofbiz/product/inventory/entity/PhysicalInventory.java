package org.apache.ofbiz.product.inventory.entity;

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

	public static final long serialVersionUID = 3350494199719003136L;
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

	public enum Fields {
		physicalInventoryId, physicalInventoryDate, partyId, generalComments
	}

	public PhysicalInventory(GenericValue value) {
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		physicalInventoryDate = (Timestamp) value
				.get(Fields.physicalInventoryDate.name());
		partyId = (String) value.get(Fields.partyId.name());
		generalComments = (String) value.get(Fields.generalComments.name());
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