package org.apache.ofbiz.content.survey.entity.view;

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

	public static final long serialVersionUID = 2711690129941472256L;
	public static final String NAME = "SurveyQuestionAndAppl";
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
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
	/**
	 * Required Field
	 */
	@Getter
	@Setter
	private String requiredField;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * External Field Ref
	 */
	@Getter
	@Setter
	private String externalFieldRef;
	/**
	 * With Survey Question Id
	 */
	@Getter
	@Setter
	private String withSurveyQuestionId;
	/**
	 * With Survey Option Seq Id
	 */
	@Getter
	@Setter
	private String withSurveyOptionSeqId;

	public enum Fields {
		surveyQuestionId, surveyQuestionCategoryId, surveyQuestionTypeId, description, question, hint, enumTypeId, geoId, formatString, surveyId, fromDate, thruDate, surveyPageSeqId, surveyMultiRespId, surveyMultiRespColId, requiredField, sequenceNum, externalFieldRef, withSurveyQuestionId, withSurveyOptionSeqId
	}

	public SurveyQuestionAndAppl(GenericValue value) {
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
		surveyId = (String) value.get(Fields.surveyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		surveyPageSeqId = (String) value.get(Fields.surveyPageSeqId.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		surveyMultiRespColId = (String) value.get(Fields.surveyMultiRespColId
				.name());
		requiredField = (String) value.get(Fields.requiredField.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		externalFieldRef = (String) value.get(Fields.externalFieldRef.name());
		withSurveyQuestionId = (String) value.get(Fields.withSurveyQuestionId
				.name());
		withSurveyOptionSeqId = (String) value.get(Fields.withSurveyOptionSeqId
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