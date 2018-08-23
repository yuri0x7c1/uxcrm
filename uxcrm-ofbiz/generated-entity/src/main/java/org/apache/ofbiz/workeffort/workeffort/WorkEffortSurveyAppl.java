package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Survey Appl
 */
@FieldNameConstants
public class WorkEffortSurveyAppl implements Serializable {

	public static final long serialVersionUID = 8987409072792978432L;
	public static final String NAME = "WorkEffortSurveyAppl";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
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

	public WorkEffortSurveyAppl(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortSurveyAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortSurveyAppl(value);
	}

	public static List<WorkEffortSurveyAppl> fromValues(
			List<GenericValue> values) {
		List<WorkEffortSurveyAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortSurveyAppl(value));
		}
		return entities;
	}
}