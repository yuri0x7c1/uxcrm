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
 * Survey Question Appl
 */
@FieldNameConstants
public class SurveyQuestionAppl implements Serializable {

	public static final long serialVersionUID = 2403801396909689856L;
	public static final String NAME = "SurveyQuestionAppl";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Question Id
	 */
	@Getter
	@Setter
	private String surveyQuestionId;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public SurveyQuestionAppl(GenericValue value) {
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyQuestionId = (String) value.get(FIELD_SURVEY_QUESTION_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		surveyPageSeqId = (String) value.get(FIELD_SURVEY_PAGE_SEQ_ID);
		surveyMultiRespId = (String) value.get(FIELD_SURVEY_MULTI_RESP_ID);
		surveyMultiRespColId = (String) value
				.get(FIELD_SURVEY_MULTI_RESP_COL_ID);
		requiredField = (String) value.get(FIELD_REQUIRED_FIELD);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		externalFieldRef = (String) value.get(FIELD_EXTERNAL_FIELD_REF);
		withSurveyQuestionId = (String) value
				.get(FIELD_WITH_SURVEY_QUESTION_ID);
		withSurveyOptionSeqId = (String) value
				.get(FIELD_WITH_SURVEY_OPTION_SEQ_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyQuestionAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionAppl(value);
	}

	public static List<SurveyQuestionAppl> fromValues(List<GenericValue> values) {
		List<SurveyQuestionAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionAppl(value));
		}
		return entities;
	}
}