package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Ical Data
 */
public class WorkEffortIcalData implements Serializable {

	public static final long serialVersionUID = 3954438562968425472L;
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

	public enum Fields {
		workEffortId, icalData
	}

	public WorkEffortIcalData(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		icalData = (String) value.get(Fields.icalData.name());
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