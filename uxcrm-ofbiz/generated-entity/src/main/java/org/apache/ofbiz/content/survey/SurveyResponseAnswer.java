package org.apache.ofbiz.content.survey;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Response Answer
 */
@FieldNameConstants
public class SurveyResponseAnswer implements Serializable {

	public static final long serialVersionUID = 6447201569291962368L;
	public static final String NAME = "SurveyResponseAnswer";
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
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

	public SurveyResponseAnswer(GenericValue value) {
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		surveyQuestionId = (String) value.get(FIELD_SURVEY_QUESTION_ID);
		surveyMultiRespColId = (String) value
				.get(FIELD_SURVEY_MULTI_RESP_COL_ID);
		surveyMultiRespId = (String) value.get(FIELD_SURVEY_MULTI_RESP_ID);
		booleanResponse = (String) value.get(FIELD_BOOLEAN_RESPONSE);
		currencyResponse = (BigDecimal) value.get(FIELD_CURRENCY_RESPONSE);
		floatResponse = (Double) value.get(FIELD_FLOAT_RESPONSE);
		numericResponse = (Long) value.get(FIELD_NUMERIC_RESPONSE);
		textResponse = (String) value.get(FIELD_TEXT_RESPONSE);
		surveyOptionSeqId = (String) value.get(FIELD_SURVEY_OPTION_SEQ_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		answeredDate = (Timestamp) value.get(FIELD_ANSWERED_DATE);
		amountBase = (BigDecimal) value.get(FIELD_AMOUNT_BASE);
		amountBaseUomId = (String) value.get(FIELD_AMOUNT_BASE_UOM_ID);
		weightFactor = (Double) value.get(FIELD_WEIGHT_FACTOR);
		duration = (Long) value.get(FIELD_DURATION);
		durationUomId = (String) value.get(FIELD_DURATION_UOM_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyResponseAnswer fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyResponseAnswer(value);
	}

	public static List<SurveyResponseAnswer> fromValues(
			List<GenericValue> values) {
		List<SurveyResponseAnswer> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyResponseAnswer(value));
		}
		return entities;
	}
}