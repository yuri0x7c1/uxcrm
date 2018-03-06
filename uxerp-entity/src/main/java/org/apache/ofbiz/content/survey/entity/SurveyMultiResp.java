package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Multi Resp
 */
public class SurveyMultiResp implements Serializable {

	public static final long serialVersionUID = 3155510445288977408L;
	public static final String NAME = "SurveyMultiResp";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Multi Resp Id
	 */
	@Getter
	@Setter
	private String surveyMultiRespId;
	/**
	 * Multi Resp Title
	 */
	@Getter
	@Setter
	private String multiRespTitle;

	public enum Fields {
		surveyId, surveyMultiRespId, multiRespTitle
	}

	public SurveyMultiResp(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		multiRespTitle = (String) value.get(Fields.multiRespTitle.name());
	}

	public static SurveyMultiResp fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyMultiResp(value);
	}

	public static List<SurveyMultiResp> fromValues(List<GenericValue> values) {
		List<SurveyMultiResp> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyMultiResp(value));
		}
		return entities;
	}
}