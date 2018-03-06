package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Trigger
 */
public class SurveyTrigger implements Serializable {

	public static final long serialVersionUID = 3233553422448840704L;
	public static final String NAME = "SurveyTrigger";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Appl Type Id
	 */
	@Getter
	@Setter
	private String surveyApplTypeId;
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
		surveyId, surveyApplTypeId, fromDate, thruDate
	}

	public SurveyTrigger(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyApplTypeId = (String) value.get(Fields.surveyApplTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static SurveyTrigger fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyTrigger(value);
	}

	public static List<SurveyTrigger> fromValues(List<GenericValue> values) {
		List<SurveyTrigger> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyTrigger(value));
		}
		return entities;
	}
}