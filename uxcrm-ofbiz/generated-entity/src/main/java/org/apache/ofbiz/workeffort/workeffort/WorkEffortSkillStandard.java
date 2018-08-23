package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WorkEffortSkillStandard implements Serializable {

	public static final long serialVersionUID = 5983654362760977408L;
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

	public WorkEffortSkillStandard(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		skillTypeId = (String) value.get(FIELD_SKILL_TYPE_ID);
		estimatedNumPeople = (Double) value.get(FIELD_ESTIMATED_NUM_PEOPLE);
		estimatedDuration = (Double) value.get(FIELD_ESTIMATED_DURATION);
		estimatedCost = (BigDecimal) value.get(FIELD_ESTIMATED_COST);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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