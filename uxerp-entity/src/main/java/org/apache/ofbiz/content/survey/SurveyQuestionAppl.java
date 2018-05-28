package org.apache.ofbiz.content.survey;

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
public class SurveyQuestionAppl implements Serializable {

	public static final long serialVersionUID = 2867038050662676480L;
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

	public enum Fields {
		surveyId, surveyQuestionId, fromDate, thruDate, surveyPageSeqId, surveyMultiRespId, surveyMultiRespColId, requiredField, sequenceNum, externalFieldRef, withSurveyQuestionId, withSurveyOptionSeqId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyQuestionAppl(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyQuestionId = (String) value.get(Fields.surveyQuestionId.name());
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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