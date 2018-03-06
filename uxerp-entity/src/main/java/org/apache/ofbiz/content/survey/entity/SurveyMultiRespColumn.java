package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Multi Resp Column
 */
public class SurveyMultiRespColumn implements Serializable {

	public static final long serialVersionUID = 7933966677556347904L;
	public static final String NAME = "SurveyMultiRespColumn";
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
	 * Survey Multi Resp Col Id
	 */
	@Getter
	@Setter
	private String surveyMultiRespColId;
	/**
	 * Column Title
	 */
	@Getter
	@Setter
	private String columnTitle;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		surveyId, surveyMultiRespId, surveyMultiRespColId, columnTitle, sequenceNum
	}

	public SurveyMultiRespColumn(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		surveyMultiRespColId = (String) value.get(Fields.surveyMultiRespColId
				.name());
		columnTitle = (String) value.get(Fields.columnTitle.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static SurveyMultiRespColumn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyMultiRespColumn(value);
	}

	public static List<SurveyMultiRespColumn> fromValues(
			List<GenericValue> values) {
		List<SurveyMultiRespColumn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyMultiRespColumn(value));
		}
		return entities;
	}
}