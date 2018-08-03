package org.apache.ofbiz.accounting.budget;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Item Type Attr
 */
public class BudgetItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 4610271950932762624L;
	public static final String NAME = "BudgetItemTypeAttr";
	/**
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		budgetItemTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetItemTypeAttr(GenericValue value) {
		budgetItemTypeId = (String) value.get(Fields.budgetItemTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static BudgetItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetItemTypeAttr(value);
	}

	public static List<BudgetItemTypeAttr> fromValues(List<GenericValue> values) {
		List<BudgetItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetItemTypeAttr(value));
		}
		return entities;
	}
}