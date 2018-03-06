package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Phase Task Skl Sum View
 */
public class ProjectPhaseTaskSklSumView implements Serializable {

	public static final long serialVersionUID = 3646128020415692800L;
	public static final String NAME = "ProjectPhaseTaskSklSumView";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCompletionDate;
	/**
	 * Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp actualCompletionDate;
	/**
	 * Estimated Duration
	 */
	@Getter
	@Setter
	private Double estimatedDuration;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;

	public enum Fields {
		workEffortId, estimatedStartDate, actualStartDate, estimatedCompletionDate, actualCompletionDate, estimatedDuration, priority
	}

	public ProjectPhaseTaskSklSumView(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		estimatedCompletionDate = (Timestamp) value
				.get(Fields.estimatedCompletionDate.name());
		actualCompletionDate = (Timestamp) value
				.get(Fields.actualCompletionDate.name());
		estimatedDuration = (Double) value.get(Fields.estimatedDuration.name());
		priority = (Long) value.get(Fields.priority.name());
	}

	public static ProjectPhaseTaskSklSumView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectPhaseTaskSklSumView(value);
	}

	public static List<ProjectPhaseTaskSklSumView> fromValues(
			List<GenericValue> values) {
		List<ProjectPhaseTaskSklSumView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectPhaseTaskSklSumView(value));
		}
		return entities;
	}
}