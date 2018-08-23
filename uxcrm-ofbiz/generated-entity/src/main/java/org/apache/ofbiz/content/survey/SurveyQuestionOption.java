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
 * Survey Question Option
 */
@FieldNameConstants
public class SurveyQuestionOption implements Serializable {

	public static final long serialVersionUID = 9051279929516534784L;
	public static final String NAME = "SurveyQuestionOption";
	/**
	 * Survey Question Id
	 */
	@Getter
	@Setter
	private String surveyQuestionId;
	/**
	 * Survey Option Seq Id
	 */
	@Getter
	@Setter
	private String surveyOptionSeqId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public SurveyQuestionOption(GenericValue value) {
		surveyQuestionId = (String) value.get(FIELD_SURVEY_QUESTION_ID);
		surveyOptionSeqId = (String) value.get(FIELD_SURVEY_OPTION_SEQ_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		amountBase = (BigDecimal) value.get(FIELD_AMOUNT_BASE);
		amountBaseUomId = (String) value.get(FIELD_AMOUNT_BASE_UOM_ID);
		weightFactor = (Double) value.get(FIELD_WEIGHT_FACTOR);
		duration = (Long) value.get(FIELD_DURATION);
		durationUomId = (String) value.get(FIELD_DURATION_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyQuestionOption fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionOption(value);
	}

	public static List<SurveyQuestionOption> fromValues(
			List<GenericValue> values) {
		List<SurveyQuestionOption> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionOption(value));
		}
		return entities;
	}
}