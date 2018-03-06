package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Question
 */
public class SurveyQuestion implements Serializable {

	public static final long serialVersionUID = 4468816273323190272L;
	public static final String NAME = "SurveyQuestion";
	/**
	 * Survey Question Id
	 */
	@Getter
	@Setter
	private String surveyQuestionId;
	/**
	 * Survey Question Category Id
	 */
	@Getter
	@Setter
	private String surveyQuestionCategoryId;
	/**
	 * Survey Question Type Id
	 */
	@Getter
	@Setter
	private String surveyQuestionTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Question
	 */
	@Getter
	@Setter
	private String question;
	/**
	 * Hint
	 */
	@Getter
	@Setter
	private String hint;
	/**
	 * Enum Type Id
	 */
	@Getter
	@Setter
	private String enumTypeId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Format String
	 */
	@Getter
	@Setter
	private String formatString;

	public enum Fields {
		surveyQuestionId, surveyQuestionCategoryId, surveyQuestionTypeId, description, question, hint, enumTypeId, geoId, formatString
	}

	public SurveyQuestion(GenericValue value) {
		surveyQuestionId = (String) value.get(Fields.surveyQuestionId.name());
		surveyQuestionCategoryId = (String) value
				.get(Fields.surveyQuestionCategoryId.name());
		surveyQuestionTypeId = (String) value.get(Fields.surveyQuestionTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		question = (String) value.get(Fields.question.name());
		hint = (String) value.get(Fields.hint.name());
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		geoId = (String) value.get(Fields.geoId.name());
		formatString = (String) value.get(Fields.formatString.name());
	}

	public static SurveyQuestion fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestion(value);
	}

	public static List<SurveyQuestion> fromValues(List<GenericValue> values) {
		List<SurveyQuestion> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestion(value));
		}
		return entities;
	}
}