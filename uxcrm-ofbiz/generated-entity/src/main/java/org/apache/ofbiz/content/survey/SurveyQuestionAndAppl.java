package org.apache.ofbiz.content.survey;

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
public class SurveyQuestionAndAppl implements Serializable {

	public static final long serialVersionUID = 8119890271394827264L;
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

	public enum Fields {
		surveyQuestionTypeId, formatString, surveyQuestionId, surveyQuestionCategoryId, question, description, enumTypeId, hint, geoId, withSurveyOptionSeqId, externalFieldRef, surveyId, sequenceNum, thruDate, fromDate, requiredField, withSurveyQuestionId, surveyPageSeqId, surveyMultiRespId, surveyMultiRespColId
	}

	public SurveyQuestionAndAppl(GenericValue value) {
		surveyQuestionTypeId = (String) value.get(Fields.surveyQuestionTypeId
				.name());
		formatString = (String) value.get(Fields.formatString.name());
		surveyQuestionId = (String) value.get(Fields.surveyQuestionId.name());
		surveyQuestionCategoryId = (String) value
				.get(Fields.surveyQuestionCategoryId.name());
		question = (String) value.get(Fields.question.name());
		description = (String) value.get(Fields.description.name());
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		hint = (String) value.get(Fields.hint.name());
		geoId = (String) value.get(Fields.geoId.name());
		withSurveyOptionSeqId = (String) value.get(Fields.withSurveyOptionSeqId
				.name());
		externalFieldRef = (String) value.get(Fields.externalFieldRef.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		requiredField = (String) value.get(Fields.requiredField.name());
		withSurveyQuestionId = (String) value.get(Fields.withSurveyQuestionId
				.name());
		surveyPageSeqId = (String) value.get(Fields.surveyPageSeqId.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		surveyMultiRespColId = (String) value.get(Fields.surveyMultiRespColId
				.name());
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