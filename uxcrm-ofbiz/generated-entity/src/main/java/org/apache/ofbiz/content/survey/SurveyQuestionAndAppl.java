package org.apache.ofbiz.content.survey;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Question And Appl
 */
@FieldNameConstants
public class SurveyQuestionAndAppl implements Serializable {

	public static final long serialVersionUID = 2403258380197322752L;
	public static final String NAME = "SurveyQuestionAndAppl";
	/**
	 * Survey Question Type Id
	 */
	@Getter
	@Setter
	private String surveyQuestionTypeId;
	/**
	 * Format String
	 */
	@Getter
	@Setter
	private String formatString;
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
	 * Question
	 */
	@Getter
	@Setter
	private String question;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Enum Type Id
	 */
	@Getter
	@Setter
	private String enumTypeId;
	/**
	 * Hint
	 */
	@Getter
	@Setter
	private String hint;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * With Survey Option Seq Id
	 */
	@Getter
	@Setter
	private String withSurveyOptionSeqId;
	/**
	 * External Field Ref
	 */
	@Getter
	@Setter
	private String externalFieldRef;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Required Field
	 */
	@Getter
	@Setter
	private String requiredField;
	/**
	 * With Survey Question Id
	 */
	@Getter
	@Setter
	private String withSurveyQuestionId;
	/**
	 * Survey Page Seq Id
	 */
	@Getter
	@Setter
	private String surveyPageSeqId;
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

	public SurveyQuestionAndAppl(GenericValue value) {
		surveyQuestionTypeId = (String) value
				.get(FIELD_SURVEY_QUESTION_TYPE_ID);
		formatString = (String) value.get(FIELD_FORMAT_STRING);
		surveyQuestionId = (String) value.get(FIELD_SURVEY_QUESTION_ID);
		surveyQuestionCategoryId = (String) value
				.get(FIELD_SURVEY_QUESTION_CATEGORY_ID);
		question = (String) value.get(FIELD_QUESTION);
		description = (String) value.get(FIELD_DESCRIPTION);
		enumTypeId = (String) value.get(FIELD_ENUM_TYPE_ID);
		hint = (String) value.get(FIELD_HINT);
		geoId = (String) value.get(FIELD_GEO_ID);
		withSurveyOptionSeqId = (String) value
				.get(FIELD_WITH_SURVEY_OPTION_SEQ_ID);
		externalFieldRef = (String) value.get(FIELD_EXTERNAL_FIELD_REF);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		requiredField = (String) value.get(FIELD_REQUIRED_FIELD);
		withSurveyQuestionId = (String) value
				.get(FIELD_WITH_SURVEY_QUESTION_ID);
		surveyPageSeqId = (String) value.get(FIELD_SURVEY_PAGE_SEQ_ID);
		surveyMultiRespId = (String) value.get(FIELD_SURVEY_MULTI_RESP_ID);
		surveyMultiRespColId = (String) value
				.get(FIELD_SURVEY_MULTI_RESP_COL_ID);
	}

	public static SurveyQuestionAndAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionAndAppl(value);
	}

	public static List<SurveyQuestionAndAppl> fromValues(
			List<GenericValue> values) {
		List<SurveyQuestionAndAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionAndAppl(value));
		}
		return entities;
	}
}