package org.apache.ofbiz.content.survey;

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
public class SurveyQuestionCategory implements Serializable {

	public static final long serialVersionUID = 5945583819443452928L;
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

	public enum Fields {
		surveyQuestionCategoryId, parentCategoryId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyQuestionCategory(GenericValue value) {
		surveyQuestionCategoryId = (String) value
				.get(Fields.surveyQuestionCategoryId.name());
		parentCategoryId = (String) value.get(Fields.parentCategoryId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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