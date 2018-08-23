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
 * Survey Question Category
 */
@FieldNameConstants
public class SurveyQuestionCategory implements Serializable {

	public static final long serialVersionUID = 8660435403732726784L;
	public static final String NAME = "SurveyQuestionCategory";
	/**
	 * Survey Question Category Id
	 */
	@Getter
	@Setter
	private String surveyQuestionCategoryId;
	/**
	 * Parent Category Id
	 */
	@Getter
	@Setter
	private String parentCategoryId;
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

	public SurveyQuestionCategory(GenericValue value) {
		surveyQuestionCategoryId = (String) value
				.get(FIELD_SURVEY_QUESTION_CATEGORY_ID);
		parentCategoryId = (String) value.get(FIELD_PARENT_CATEGORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyQuestionCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyQuestionCategory(value);
	}

	public static List<SurveyQuestionCategory> fromValues(
			List<GenericValue> values) {
		List<SurveyQuestionCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyQuestionCategory(value));
		}
		return entities;
	}
}