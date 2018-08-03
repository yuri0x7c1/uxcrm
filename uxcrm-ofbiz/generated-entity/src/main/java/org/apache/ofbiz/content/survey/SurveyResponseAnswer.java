package org.apache.ofbiz.content.survey;

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
public class SurveyResponseAnswer implements Serializable {

	public static final long serialVersionUID = 7551780967291770880L;
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

	public enum Fields {
		surveyResponseId, surveyQuestionId, surveyMultiRespColId, surveyMultiRespId, booleanResponse, currencyResponse, floatResponse, numericResponse, textResponse, surveyOptionSeqId, contentId, answeredDate, amountBase, amountBaseUomId, weightFactor, duration, durationUomId, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyResponseAnswer(GenericValue value) {
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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