package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Phase Task Assignment View
 */
public class ProjectPhaseTaskAssignmentView implements Serializable {

	public static final long serialVersionUID = 6023928545845235712L;
	public static final String NAME = "ProjectPhaseTaskAssignmentView";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Time Entry Id
	 */
	@Getter
	@Setter
	private String timeEntryId;

	public enum Fields {
		workEffortId, currentStatusId, partyId, timeEntryId
	}

	public ProjectPhaseTaskAssignmentView(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		partyId = (String) value.get(Fields.partyId.name());
		timeEntryId = (String) value.get(Fields.timeEntryId.name());
	}

	public static ProjectPhaseTaskAssignmentView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectPhaseTaskAssignmentView(value);
	}

	public static List<ProjectPhaseTaskAssignmentView> fromValues(
			List<GenericValue> values) {
		List<ProjectPhaseTaskAssignmentView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectPhaseTaskAssignmentView(value));
		}
		return entities;
	}
}