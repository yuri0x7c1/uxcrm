package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Survey Appl
 */
public class WorkEffortSurveyAppl implements Serializable {

	public static final long serialVersionUID = 6679030526033271808L;
	public static final String NAME = "WorkEffortSurveyAppl";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
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

	public enum Fields {
		workEffortId, surveyId, fromDate, thruDate
	}

	public WorkEffortSurveyAppl(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static WorkEffortSurveyAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortSurveyAppl(value);
	}

	public static List<WorkEffortSurveyAppl> fromValues(
			List<GenericValue> values) {
		List<WorkEffortSurveyAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortSurveyAppl(value));
		}
		return entities;
	}
}