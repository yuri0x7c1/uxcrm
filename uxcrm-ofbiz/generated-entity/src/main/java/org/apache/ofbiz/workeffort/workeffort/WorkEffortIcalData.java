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
 * Work Effort Ical Data
 */
@FieldNameConstants
public class WorkEffortIcalData implements Serializable {

	public static final long serialVersionUID = 7947072563177399296L;
	public static final String NAME = "WorkEffortIcalData";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Ical Data
	 */
	@Getter
	@Setter
	private String icalData;
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

	public WorkEffortIcalData(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		icalData = (String) value.get(FIELD_ICAL_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortIcalData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortIcalData(value);
	}

	public static List<WorkEffortIcalData> fromValues(List<GenericValue> values) {
		List<WorkEffortIcalData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortIcalData(value));
		}
		return entities;
	}
}