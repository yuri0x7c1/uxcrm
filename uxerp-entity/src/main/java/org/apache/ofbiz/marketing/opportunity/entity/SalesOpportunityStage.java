package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Stage
 */
public class SalesOpportunityStage implements Serializable {

	public static final long serialVersionUID = 8977657142339056640L;
	public static final String NAME = "SalesOpportunityStage";
	/**
	 * Opportunity Stage Id
	 */
	@Getter
	@Setter
	private String opportunityStageId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Probability
	 */
	@Getter
	@Setter
	private BigDecimal defaultProbability;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		opportunityStageId, description, defaultProbability, sequenceNum
	}

	public SalesOpportunityStage(GenericValue value) {
		opportunityStageId = (String) value.get(Fields.opportunityStageId
				.name());
		description = (String) value.get(Fields.description.name());
		defaultProbability = (BigDecimal) value.get(Fields.defaultProbability
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static SalesOpportunityStage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityStage(value);
	}

	public static List<SalesOpportunityStage> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityStage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityStage(value));
		}
		return entities;
	}
}