package org.apache.ofbiz.content.survey;

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
public class SurveyTrigger implements Serializable {

	public static final long serialVersionUID = 1371299735809220608L;
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

	public enum Fields {
		surveyId, surveyApplTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyTrigger(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyApplTypeId = (String) value.get(Fields.surveyApplTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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