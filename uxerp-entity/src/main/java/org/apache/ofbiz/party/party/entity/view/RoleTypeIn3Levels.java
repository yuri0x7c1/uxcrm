package org.apache.ofbiz.party.party.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type In 3 Levels
 */
public class RoleTypeIn3Levels implements Serializable {

	public static final long serialVersionUID = 4236792987056893952L;
	public static final String NAME = "RoleTypeIn3Levels";
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
		roleTypeId, description
	}

	public RoleTypeIn3Levels(GenericValue value) {
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RoleTypeIn3Levels fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RoleTypeIn3Levels(value);
	}

	public static List<RoleTypeIn3Levels> fromValues(List<GenericValue> values) {
		List<RoleTypeIn3Levels> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RoleTypeIn3Levels(value));
		}
		return entities;
	}
}