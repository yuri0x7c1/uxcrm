package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortIcalData implements Serializable {

	public static final long serialVersionUID = 5713270827415078912L;
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

	public enum Fields {
		workEffortId, icalData, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortIcalData(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		icalData = (String) value.get(Fields.icalData.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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