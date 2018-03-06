package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Id Party Role And Task
 */
public class ProjectIdPartyRoleAndTask implements Serializable {

	public static final long serialVersionUID = 3098433488926444544L;
	public static final String NAME = "ProjectIdPartyRoleAndTask";
	/**
	 * Work Effort Parent Id
	 */
	@Getter
	@Setter
	private String workEffortParentId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		workEffortParentId, workEffortId, partyId, roleTypeId, description
	}

	public ProjectIdPartyRoleAndTask(GenericValue value) {
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProjectIdPartyRoleAndTask fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectIdPartyRoleAndTask(value);
	}

	public static List<ProjectIdPartyRoleAndTask> fromValues(
			List<GenericValue> values) {
		List<ProjectIdPartyRoleAndTask> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectIdPartyRoleAndTask(value));
		}
		return entities;
	}
}