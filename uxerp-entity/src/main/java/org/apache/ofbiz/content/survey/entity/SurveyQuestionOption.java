package org.apache.ofbiz.content.survey.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Question Option
 */
public class SurveyQuestionOption implements Serializable {

	public static final long serialVersionUID = 365029567565090816L;
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

	public enum Fields {
		surveyQuestionId, surveyOptionSeqId, description, sequenceNum, amountBase, amountBaseUomId, weightFactor, duration, durationUomId
	}

	public SurveyQuestionOption(GenericValue value) {
		surveyQuestionId = (String) value.get(Fields.surveyQuestionId.name());
		surveyOptionSeqId = (String) value.get(Fields.surveyOptionSeqId.name());
		description = (String) value.get(Fields.description.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		amountBase = (BigDecimal) value.get(Fields.amountBase.name());
		amountBaseUomId = (String) value.get(Fields.amountBaseUomId.name());
		weightFactor = (Double) value.get(Fields.weightFactor.name());
		duration = (Long) value.get(Fields.duration.name());
		durationUomId = (String) value.get(Fields.durationUomId.name());
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