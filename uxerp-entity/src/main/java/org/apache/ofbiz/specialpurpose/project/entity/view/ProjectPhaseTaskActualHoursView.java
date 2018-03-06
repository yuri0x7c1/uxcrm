package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Phase Task Actual Hours View
 */
public class ProjectPhaseTaskActualHoursView implements Serializable {

	public static final long serialVersionUID = 1602414283832609792L;
	public static final String NAME = "ProjectPhaseTaskActualHoursView";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Time Entry Id
	 */
	@Getter
	@Setter
	private String timeEntryId;
	/**
	 * Hours
	 */
	@Getter
	@Setter
	private Double hours;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Percentage Used
	 */
	@Getter
	@Setter
	private Double percentageUsed;

	public enum Fields {
		workEffortId, timeEntryId, hours, partyId, invoiceId, percentageUsed
	}

	public ProjectPhaseTaskActualHoursView(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		timeEntryId = (String) value.get(Fields.timeEntryId.name());
		hours = (Double) value.get(Fields.hours.name());
		partyId = (String) value.get(Fields.partyId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		percentageUsed = (Double) value.get(Fields.percentageUsed.name());
	}

	public static ProjectPhaseTaskActualHoursView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectPhaseTaskActualHoursView(value);
	}

	public static List<ProjectPhaseTaskActualHoursView> fromValues(
			List<GenericValue> values) {
		List<ProjectPhaseTaskActualHoursView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectPhaseTaskActualHoursView(value));
		}
		return entities;
	}
}