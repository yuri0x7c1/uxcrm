package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Question Category
 */
public class SurveyQuestionCategory implements Serializable {

	public static final long serialVersionUID = 702573998845918208L;
	public static final String NAME = "SurveyQuestionCategory";
	/**
	 * Survey Question Category Id
	 */
	@Getter
	@Setter
	private String surveyQuestionCategoryId;
	/**
	 * Parent Category Id
	 */
	@Getter
	@Setter
	private String parentCategoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		surveyQuestionCategoryId, parentCategoryId, description
	}

	public SurveyQuestionCategory(GenericValue value) {
		surveyQuestionCategoryId = (String) value
				.get(Fields.surveyQuestionCategoryId.name());
		parentCategoryId = (String) value.get(Fields.parentCategoryId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SurveyQuestionCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionCategory(value);
	}

	public static List<SurveyQuestionCategory> fromValues(
			List<GenericValue> values) {
		List<SurveyQuestionCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionCategory(value));
		}
		return entities;
	}
}