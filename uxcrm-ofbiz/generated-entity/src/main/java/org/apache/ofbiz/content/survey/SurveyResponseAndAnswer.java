package org.apache.ofbiz.content.survey;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class SurveyResponseAndAnswer implements Serializable {

	public static final long serialVersionUID = 5800645784693462016L;
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

	public SurveyResponseAndAnswer(GenericValue value) {
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		orderId = (String) value.get(FIELD_ORDER_ID);
		generalFeedback = (String) value.get(FIELD_GENERAL_FEEDBACK);
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		responseDate = (Timestamp) value.get(FIELD_RESPONSE_DATE);
		referenceId = (String) value.get(FIELD_REFERENCE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		amountBase = (BigDecimal) value.get(FIELD_AMOUNT_BASE);
		surveyQuestionId = (String) value.get(FIELD_SURVEY_QUESTION_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		surveyOptionSeqId = (String) value.get(FIELD_SURVEY_OPTION_SEQ_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		durationUomId = (String) value.get(FIELD_DURATION_UOM_ID);
		currencyResponse = (BigDecimal) value.get(FIELD_CURRENCY_RESPONSE);
		floatResponse = (Double) value.get(FIELD_FLOAT_RESPONSE);
		numericResponse = (Long) value.get(FIELD_NUMERIC_RESPONSE);
		duration = (Long) value.get(FIELD_DURATION);
		answeredDate = (Timestamp) value.get(FIELD_ANSWERED_DATE);
		textResponse = (String) value.get(FIELD_TEXT_RESPONSE);
		amountBaseUomId = (String) value.get(FIELD_AMOUNT_BASE_UOM_ID);
		booleanResponse = (String) value.get(FIELD_BOOLEAN_RESPONSE);
		weightFactor = (Double) value.get(FIELD_WEIGHT_FACTOR);
		surveyMultiRespColId = (String) value
				.get(FIELD_SURVEY_MULTI_RESP_COL_ID);
		surveyMultiRespId = (String) value.get(FIELD_SURVEY_MULTI_RESP_ID);
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