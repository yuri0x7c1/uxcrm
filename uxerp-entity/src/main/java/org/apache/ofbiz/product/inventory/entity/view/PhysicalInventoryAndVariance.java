package org.apache.ofbiz.product.inventory.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Physical Inventory And Variance
 */
public class PhysicalInventoryAndVariance implements Serializable {

	public static final long serialVersionUID = 8659629308474911744L;
	public static final String NAME = "PhysicalInventoryAndVariance";
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
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Variance Reason Id
	 */
	@Getter
	@Setter
	private String varianceReasonId;
	/**
	 * Available To Promise Var
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseVar;
	/**
	 * Quantity On Hand Var
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandVar;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		physicalInventoryId, physicalInventoryDate, partyId, generalComments, inventoryItemId, varianceReasonId, availableToPromiseVar, quantityOnHandVar, comments
	}

	public PhysicalInventoryAndVariance(GenericValue value) {
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		physicalInventoryDate = (Timestamp) value
				.get(Fields.physicalInventoryDate.name());
		partyId = (String) value.get(Fields.partyId.name());
		generalComments = (String) value.get(Fields.generalComments.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		varianceReasonId = (String) value.get(Fields.varianceReasonId.name());
		availableToPromiseVar = (BigDecimal) value
				.get(Fields.availableToPromiseVar.name());
		quantityOnHandVar = (BigDecimal) value.get(Fields.quantityOnHandVar
				.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static PhysicalInventoryAndVariance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PhysicalInventoryAndVariance(value);
	}

	public static List<PhysicalInventoryAndVariance> fromValues(
			List<GenericValue> values) {
		List<PhysicalInventoryAndVariance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PhysicalInventoryAndVariance(value));
		}
		return entities;
	}
}