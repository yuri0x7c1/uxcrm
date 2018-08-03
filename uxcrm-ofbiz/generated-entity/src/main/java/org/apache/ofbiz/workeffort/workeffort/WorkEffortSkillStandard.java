package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Skill Standard
 */
public class WorkEffortSkillStandard implements Serializable {

	public static final long serialVersionUID = 2566920956600371200L;
	public static final String NAME = "WorkEffortSkillStandard";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Skill Type Id
	 */
	@Getter
	@Setter
	private String skillTypeId;
	/**
	 * Estimated Num People
	 */
	@Getter
	@Setter
	private Double estimatedNumPeople;
	/**
	 * Estimated Duration
	 */
	@Getter
	@Setter
	private Double estimatedDuration;
	/**
	 * Estimated Cost
	 */
	@Getter
	@Setter
	private BigDecimal estimatedCost;
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
		workEffortId, skillTypeId, estimatedNumPeople, estimatedDuration, estimatedCost, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortSkillStandard(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		skillTypeId = (String) value.get(Fields.skillTypeId.name());
		estimatedNumPeople = (Double) value.get(Fields.estimatedNumPeople
				.name());
		estimatedDuration = (Double) value.get(Fields.estimatedDuration.name());
		estimatedCost = (BigDecimal) value.get(Fields.estimatedCost.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortSkillStandard fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortSkillStandard(value);
	}

	public static List<WorkEffortSkillStandard> fromValues(
			List<GenericValue> values) {
		List<WorkEffortSkillStandard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortSkillStandard(value));
		}
		return entities;
	}
}