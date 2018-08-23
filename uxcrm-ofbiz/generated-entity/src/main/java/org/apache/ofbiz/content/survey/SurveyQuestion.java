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
 * Survey Question
 */
@FieldNameConstants
public class SurveyQuestion implements Serializable {

	public static final long serialVersionUID = 8875959392207998976L;
	public static final String NAME = "SurveyQuestion";
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

	public SurveyQuestion(GenericValue value) {
		surveyQuestionId = (String) value.get(FIELD_SURVEY_QUESTION_ID);
		surveyQuestionCategoryId = (String) value
				.get(FIELD_SURVEY_QUESTION_CATEGORY_ID);
		surveyQuestionTypeId = (String) value
				.get(FIELD_SURVEY_QUESTION_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		question = (String) value.get(FIELD_QUESTION);
		hint = (String) value.get(FIELD_HINT);
		enumTypeId = (String) value.get(FIELD_ENUM_TYPE_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		formatString = (String) value.get(FIELD_FORMAT_STRING);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyQuestion fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestion(value);
	}

	public static List<SurveyQuestion> fromValues(List<GenericValue> values) {
		List<SurveyQuestion> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestion(value));
		}
		return entities;
	}
}