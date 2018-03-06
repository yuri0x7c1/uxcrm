package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Revision
 */
public class BudgetRevision implements Serializable {

	public static final long serialVersionUID = 8820996143547885568L;
	public static final String NAME = "BudgetRevision";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Revision Seq Id
	 */
	@Getter
	@Setter
	private String revisionSeqId;
	/**
	 * Date Revised
	 */
	@Getter
	@Setter
	private Timestamp dateRevised;

	public enum Fields {
		budgetId, revisionSeqId, dateRevised
	}

	public BudgetRevision(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		revisionSeqId = (String) value.get(Fields.revisionSeqId.name());
		dateRevised = (Timestamp) value.get(Fields.dateRevised.name());
	}

	public static BudgetRevision fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetRevision(value);
	}

	public static List<BudgetRevision> fromValues(List<GenericValue> values) {
		List<BudgetRevision> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetRevision(value));
		}
		return entities;
	}
}