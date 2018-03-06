package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Phase Task Actual Entry Sum View
 */
public class ProjectPhaseTaskActualEntrySumView implements Serializable {

	public static final long serialVersionUID = 357936132006670336L;
	public static final String NAME = "ProjectPhaseTaskActualEntrySumView";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;

	public enum Fields {
		workEffortId, fromDate
	}

	public ProjectPhaseTaskActualEntrySumView(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
	}

	public static ProjectPhaseTaskActualEntrySumView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectPhaseTaskActualEntrySumView(value);
	}

	public static List<ProjectPhaseTaskActualEntrySumView> fromValues(
			List<GenericValue> values) {
		List<ProjectPhaseTaskActualEntrySumView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectPhaseTaskActualEntrySumView(value));
		}
		return entities;
	}
}