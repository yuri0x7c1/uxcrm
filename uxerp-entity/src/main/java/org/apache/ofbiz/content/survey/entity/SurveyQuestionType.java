package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Question Type
 */
public class SurveyQuestionType implements Serializable {

	public static final long serialVersionUID = 7486137241275561984L;
	public static final String NAME = "SurveyQuestionType";
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

	public enum Fields {
		surveyQuestionTypeId, description
	}

	public SurveyQuestionType(GenericValue value) {
		surveyQuestionTypeId = (String) value.get(Fields.surveyQuestionTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SurveyQuestionType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionType(value);
	}

	public static List<SurveyQuestionType> fromValues(List<GenericValue> values) {
		List<SurveyQuestionType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionType(value));
		}
		return entities;
	}
}