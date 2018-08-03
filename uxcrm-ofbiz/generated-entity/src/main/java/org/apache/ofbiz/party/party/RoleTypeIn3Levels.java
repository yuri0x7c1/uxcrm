package org.apache.ofbiz.party.party;

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

	public static final long serialVersionUID = 2344960432316356608L;
	public static final String NAME = "RoleTypeIn3Levels";
	/**
	 * Top Role Type Id
	 */
	@Getter
	@Setter
	private String topRoleTypeId;
	/**
	 * Top Description
	 */
	@Getter
	@Setter
	private String topDescription;
	/**
	 * Mid Role Type Id
	 */
	@Getter
	@Setter
	private String midRoleTypeId;
	/**
	 * Mid Description
	 */
	@Getter
	@Setter
	private String midDescription;
	/**
	 * Low Role Type Id
	 */
	@Getter
	@Setter
	private String lowRoleTypeId;
	/**
	 * Low Description
	 */
	@Getter
	@Setter
	private String lowDescription;

	public enum Fields {
		topRoleTypeId, topDescription, midRoleTypeId, midDescription, lowRoleTypeId, lowDescription
	}

	public RoleTypeIn3Levels(GenericValue value) {
		topRoleTypeId = (String) value.get(Fields.topRoleTypeId.name());
		topDescription = (String) value.get(Fields.topDescription.name());
		midRoleTypeId = (String) value.get(Fields.midRoleTypeId.name());
		midDescription = (String) value.get(Fields.midDescription.name());
		lowRoleTypeId = (String) value.get(Fields.lowRoleTypeId.name());
		lowDescription = (String) value.get(Fields.lowDescription.name());
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