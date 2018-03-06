package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Page
 */
public class SurveyPage implements Serializable {

	public static final long serialVersionUID = 1861712235754946560L;
	public static final String NAME = "SurveyPage";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Page Seq Id
	 */
	@Getter
	@Setter
	private String surveyPageSeqId;
	/**
	 * Page Name
	 */
	@Getter
	@Setter
	private String pageName;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		surveyId, surveyPageSeqId, pageName, sequenceNum
	}

	public SurveyPage(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyPageSeqId = (String) value.get(Fields.surveyPageSeqId.name());
		pageName = (String) value.get(Fields.pageName.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static SurveyPage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyPage(value);
	}

	public static List<SurveyPage> fromValues(List<GenericValue> values) {
		List<SurveyPage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyPage(value));
		}
		return entities;
	}
}