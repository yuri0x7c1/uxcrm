package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PhysicalInventory implements Serializable {

	public static final long serialVersionUID = 674275558542842880L;
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

	public PhysicalInventory(GenericValue value) {
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		physicalInventoryDate = (Timestamp) value
				.get(FIELD_PHYSICAL_INVENTORY_DATE);
		partyId = (String) value.get(FIELD_PARTY_ID);
		generalComments = (String) value.get(FIELD_GENERAL_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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