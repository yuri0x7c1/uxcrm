package org.apache.ofbiz.accounting.budget;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class BudgetRevision implements Serializable {

	public static final long serialVersionUID = 887607967661275136L;
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

	public BudgetRevision(GenericValue value) {
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		revisionSeqId = (String) value.get(FIELD_REVISION_SEQ_ID);
		dateRevised = (Timestamp) value.get(FIELD_DATE_REVISED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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