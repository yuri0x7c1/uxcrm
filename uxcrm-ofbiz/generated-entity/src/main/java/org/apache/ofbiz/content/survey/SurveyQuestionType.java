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
 * Survey Question Type
 */
@FieldNameConstants
public class SurveyQuestionType implements Serializable {

	public static final long serialVersionUID = 4478677832610783232L;
	public static final String NAME = "SurveyQuestionType";
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

	public SurveyQuestionType(GenericValue value) {
		surveyQuestionTypeId = (String) value
				.get(FIELD_SURVEY_QUESTION_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyQuestionType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionType(value);
	}

	public static List<SurveyQuestionType> fromValues(List<GenericValue> values) {
		List<SurveyQuestionType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionType(value));
		}
		return entities;
	}
}