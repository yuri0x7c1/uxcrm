package org.apache.ofbiz.content.survey.entity.view;

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

	public static final long serialVersionUID = 7051361914206862336L;
	public static final String NAME = "SurveyResponseAndAnswer";
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Response Date
	 */
	@Getter
	@Setter
	private Timestamp responseDate;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Reference Id
	 */
	@Getter
	@Setter
	private String referenceId;
	/**
	 * General Feedback
	 */
	@Getter
	@Setter
	private String generalFeedback;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Survey Question Id
	 */
	@Getter
	@Setter
	private String surveyQuestionId;
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
	/**
	 * Boolean Response
	 */
	@Getter
	@Setter
	private String booleanResponse;
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
	 * Text Response
	 */
	@Getter
	@Setter
	private String textResponse;
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
	 * Answered Date
	 */
	@Getter
	@Setter
	private Timestamp answeredDate;
	/**
	 * Amount Base
	 */
	@Getter
	@Setter
	private BigDecimal amountBase;
	/**
	 * Amount Base Uom Id
	 */
	@Getter
	@Setter
	private String amountBaseUomId;
	/**
	 * Weight Factor
	 */
	@Getter
	@Setter
	private Double weightFactor;
	/**
	 * Duration
	 */
	@Getter
	@Setter
	private Long duration;
	/**
	 * Duration Uom Id
	 */
	@Getter
	@Setter
	private String durationUomId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		surveyResponseId, surveyId, partyId, responseDate, lastModifiedDate, referenceId, generalFeedback, orderId, orderItemSeqId, statusId, surveyQuestionId, surveyMultiRespColId, surveyMultiRespId, booleanResponse, currencyResponse, floatResponse, numericResponse, textResponse, surveyOptionSeqId, contentId, answeredDate, amountBase, amountBaseUomId, weightFactor, duration, durationUomId, sequenceNum
	}

	public SurveyResponseAndAnswer(GenericValue value) {
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		partyId = (String) value.get(Fields.partyId.name());
		responseDate = (Timestamp) value.get(Fields.responseDate.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		referenceId = (String) value.get(Fields.referenceId.name());
		generalFeedback = (String) value.get(Fields.generalFeedback.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		statusId = (String) value.get(Fields.statusId.name());
		surveyQuestionId = (String) value.get(Fields.surveyQuestionId.name());
		surveyMultiRespColId = (String) value.get(Fields.surveyMultiRespColId
				.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		booleanResponse = (String) value.get(Fields.booleanResponse.name());
		currencyResponse = (BigDecimal) value.get(Fields.currencyResponse
				.name());
		floatResponse = (Double) value.get(Fields.floatResponse.name());
		numericResponse = (Long) value.get(Fields.numericResponse.name());
		textResponse = (String) value.get(Fields.textResponse.name());
		surveyOptionSeqId = (String) value.get(Fields.surveyOptionSeqId.name());
		contentId = (String) value.get(Fields.contentId.name());
		answeredDate = (Timestamp) value.get(Fields.answeredDate.name());
		amountBase = (BigDecimal) value.get(Fields.amountBase.name());
		amountBaseUomId = (String) value.get(Fields.amountBaseUomId.name());
		weightFactor = (Double) value.get(Fields.weightFactor.name());
		duration = (Long) value.get(Fields.duration.name());
		durationUomId = (String) value.get(Fields.durationUomId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
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