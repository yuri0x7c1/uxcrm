package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Id Party Role And Phase
 */
public class ProjectIdPartyRoleAndPhase implements Serializable {

	public static final long serialVersionUID = 3706082544377927680L;
	public static final String NAME = "ProjectIdPartyRoleAndPhase";
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

	public ProjectIdPartyRoleAndPhase(GenericValue value) {
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProjectIdPartyRoleAndPhase fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectIdPartyRoleAndPhase(value);
	}

	public static List<ProjectIdPartyRoleAndPhase> fromValues(
			List<GenericValue> values) {
		List<ProjectIdPartyRoleAndPhase> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectIdPartyRoleAndPhase(value));
		}
		return entities;
	}
}