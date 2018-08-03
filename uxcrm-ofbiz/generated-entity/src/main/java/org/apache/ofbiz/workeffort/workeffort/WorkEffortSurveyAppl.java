package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortSurveyAppl implements Serializable {

	public static final long serialVersionUID = 2562439282296750080L;
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

	public enum Fields {
		workEffortId, surveyId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortSurveyAppl(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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