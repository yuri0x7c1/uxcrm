package org.apache.ofbiz.content.survey;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Response And Answer
 */
public class SurveyResponseAndAnswer implements Serializable {

	public static final long serialVersionUID = 3349703989233907712L;
	public static final String NAME = "SurveyResponseAndAnswer";
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * General Feedback
	 */
	@Getter
	@Setter
	private String generalFeedback;
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Response Date
	 */
	@Getter
	@Setter
	private Timestamp responseDate;
	/**
	 * Reference Id
	 */
	@Getter
	@Setter
	private String referenceId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Amount Base
	 */
	@Getter
	@Setter
	private BigDecimal amountBase;
	/**
	 * Survey Question Id
	 */
	@Getter
	@Setter
	private String surveyQuestionId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Survey Option Seq Id
	 */
	@Getter
	@Setter
	private String surveyOptionSeqId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Duration Uom Id
	 */
	@Getter
	@Setter
	private String durationUomId;
	/**
	 * Currency Response
	 */
	@Getter
	@Setter
	private BigDecimal currencyResponse;
	/**
	 * Float Response
	 */
	@Getter
	@Setter
	private Double floatResponse;
	/**
	 * Numeric Response
	 */
	@Getter
	@Setter
	private Long numericResponse;
	/**
	 * Duration
	 */
	@Getter
	@Setter
	private Long duration;
	/**
	 * Answered Date
	 */
	@Getter
	@Setter
	private Timestamp answeredDate;
	/**
	 * Text Response
	 */
	@Getter
	@Setter
	private String textResponse;
	/**
	 * Amount Base Uom Id
	 */
	@Getter
	@Setter
	private String amountBaseUomId;
	/**
	 * Boolean Response
	 */
	@Getter
	@Setter
	private String booleanResponse;
	/**
	 * Weight Factor
	 */
	@Getter
	@Setter
	private Double weightFactor;
	/**
	 * Survey Multi Resp Col Id
	 */
	@Getter
	@Setter
	private String surveyMultiRespColId;
	/**
	 * Survey Multi Resp Id
	 */
	@Getter
	@Setter
	private String surveyMultiRespId;

	public enum Fields {
		orderItemSeqId, surveyId, lastModifiedDate, orderId, generalFeedback, surveyResponseId, responseDate, referenceId, statusId, partyId, amountBase, surveyQuestionId, sequenceNum, surveyOptionSeqId, contentId, durationUomId, currencyResponse, floatResponse, numericResponse, duration, answeredDate, textResponse, amountBaseUomId, booleanResponse, weightFactor, surveyMultiRespColId, surveyMultiRespId
	}

	public SurveyResponseAndAnswer(GenericValue value) {
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		orderId = (String) value.get(Fields.orderId.name());
		generalFeedback = (String) value.get(Fields.generalFeedback.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		responseDate = (Timestamp) value.get(Fields.responseDate.name());
		referenceId = (String) value.get(Fields.referenceId.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyId = (String) value.get(Fields.partyId.name());
		amountBase = (BigDecimal) value.get(Fields.amountBase.name());
		surveyQuestionId = (String) value.get(Fields.surveyQuestionId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		surveyOptionSeqId = (String) value.get(Fields.surveyOptionSeqId.name());
		contentId = (String) value.get(Fields.contentId.name());
		durationUomId = (String) value.get(Fields.durationUomId.name());
		currencyResponse = (BigDecimal) value.get(Fields.currencyResponse
				.name());
		floatResponse = (Double) value.get(Fields.floatResponse.name());
		numericResponse = (Long) value.get(Fields.numericResponse.name());
		duration = (Long) value.get(Fields.duration.name());
		answeredDate = (Timestamp) value.get(Fields.answeredDate.name());
		textResponse = (String) value.get(Fields.textResponse.name());
		amountBaseUomId = (String) value.get(Fields.amountBaseUomId.name());
		booleanResponse = (String) value.get(Fields.booleanResponse.name());
		weightFactor = (Double) value.get(Fields.weightFactor.name());
		surveyMultiRespColId = (String) value.get(Fields.surveyMultiRespColId
				.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
	}

	public static SurveyResponseAndAnswer fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyResponseAndAnswer(value);
	}

	public static List<SurveyResponseAndAnswer> fromValues(
			List<GenericValue> values) {
		List<SurveyResponseAndAnswer> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyResponseAndAnswer(value));
		}
		return entities;
	}
}