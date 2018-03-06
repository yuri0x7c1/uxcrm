package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Work Effort
 */
public class SalesOpportunityWorkEffort implements Serializable {

	public static final long serialVersionUID = 8129486824496724992L;
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

	public enum Fields {
		salesOpportunityId, workEffortId
	}

	public SalesOpportunityWorkEffort(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
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