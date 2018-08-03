package org.apache.ofbiz.accounting.budget;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Type Attr
 */
public class BudgetTypeAttr implements Serializable {

	public static final long serialVersionUID = 5420358998999900160L;
	public static final String NAME = "BudgetTypeAttr";
	/**
	 * Budget Type Id
	 */
	@Getter
	@Setter
	private String budgetTypeId;
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
		budgetTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetTypeAttr(GenericValue value) {
		budgetTypeId = (String) value.get(Fields.budgetTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static BudgetTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetTypeAttr(value);
	}

	public static List<BudgetTypeAttr> fromValues(List<GenericValue> values) {
		List<BudgetTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetTypeAttr(value));
		}
		return entities;
	}
}