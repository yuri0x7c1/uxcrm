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
 * Survey Trigger
 */
@FieldNameConstants
public class SurveyTrigger implements Serializable {

	public static final long serialVersionUID = 723853270005704704L;
	public static final String NAME = "SurveyTrigger";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Appl Type Id
	 */
	@Getter
	@Setter
	private String surveyApplTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public SurveyTrigger(GenericValue value) {
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyApplTypeId = (String) value.get(FIELD_SURVEY_APPL_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyTrigger fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyTrigger(value);
	}

	public static List<SurveyTrigger> fromValues(List<GenericValue> values) {
		List<SurveyTrigger> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyTrigger(value));
		}
		return entities;
	}
}