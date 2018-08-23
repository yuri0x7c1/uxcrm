package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Work Effort
 */
@FieldNameConstants
public class SalesOpportunityWorkEffort implements Serializable {

	public static final long serialVersionUID = 6365785656465327104L;
	public static final String NAME = "SalesOpportunityWorkEffort";
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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

	public SalesOpportunityWorkEffort(GenericValue value) {
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SalesOpportunityWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityWorkEffort(value);
	}

	public static List<SalesOpportunityWorkEffort> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityWorkEffort(value));
		}
		return entities;
	}
}