package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Appl Type
 */
public class SurveyApplType implements Serializable {

	public static final long serialVersionUID = 4840588964413956096L;
	public static final String NAME = "SurveyApplType";
	/**
	 * Survey Appl Type Id
	 */
	@Getter
	@Setter
	private String surveyApplTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		surveyApplTypeId, description
	}

	public SurveyApplType(GenericValue value) {
		surveyApplTypeId = (String) value.get(Fields.surveyApplTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SurveyApplType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyApplType(value);
	}

	public static List<SurveyApplType> fromValues(List<GenericValue> values) {
		List<SurveyApplType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyApplType(value));
		}
		return entities;
	}
}