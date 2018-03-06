package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Budget Xref
 */
public class GlBudgetXref implements Serializable {

	public static final long serialVersionUID = 4726306009776532480L;
	public static final String NAME = "GlBudgetXref";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Allocation Percentage
	 */
	@Getter
	@Setter
	private BigDecimal allocationPercentage;

	public enum Fields {
		glAccountId, budgetItemTypeId, fromDate, thruDate, allocationPercentage
	}

	public GlBudgetXref(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		budgetItemTypeId = (String) value.get(Fields.budgetItemTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		allocationPercentage = (BigDecimal) value
				.get(Fields.allocationPercentage.name());
	}

	public static GlBudgetXref fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlBudgetXref(value);
	}

	public static List<GlBudgetXref> fromValues(List<GenericValue> values) {
		List<GlBudgetXref> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlBudgetXref(value));
		}
		return entities;
	}
}