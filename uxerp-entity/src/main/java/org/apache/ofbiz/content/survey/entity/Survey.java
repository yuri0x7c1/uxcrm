package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey
 */
public class Survey implements Serializable {

	public static final long serialVersionUID = 164985915062822912L;
	public static final String NAME = "Survey";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Name
	 */
	@Getter
	@Setter
	private String surveyName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Submit Caption
	 */
	@Getter
	@Setter
	private String submitCaption;
	/**
	 * Response Service
	 */
	@Getter
	@Setter
	private String responseService;
	/**
	 * Is Anonymous
	 */
	@Getter
	@Setter
	private String isAnonymous;
	/**
	 * Allow Multiple
	 */
	@Getter
	@Setter
	private String allowMultiple;
	/**
	 * Allow Update
	 */
	@Getter
	@Setter
	private String allowUpdate;
	/**
	 * Acro Form Content Id
	 */
	@Getter
	@Setter
	private String acroFormContentId;

	public enum Fields {
		surveyId, surveyName, description, comments, submitCaption, responseService, isAnonymous, allowMultiple, allowUpdate, acroFormContentId
	}

	public Survey(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyName = (String) value.get(Fields.surveyName.name());
		description = (String) value.get(Fields.description.name());
		comments = (String) value.get(Fields.comments.name());
		submitCaption = (String) value.get(Fields.submitCaption.name());
		responseService = (String) value.get(Fields.responseService.name());
		isAnonymous = (String) value.get(Fields.isAnonymous.name());
		allowMultiple = (String) value.get(Fields.allowMultiple.name());
		allowUpdate = (String) value.get(Fields.allowUpdate.name());
		acroFormContentId = (String) value.get(Fields.acroFormContentId.name());
	}

	public static Survey fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Survey(value);
	}

	public static List<Survey> fromValues(List<GenericValue> values) {
		List<Survey> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Survey(value));
		}
		return entities;
	}
}