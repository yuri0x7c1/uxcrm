package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type In 3 Levels
 */
@FieldNameConstants
public class RoleTypeIn3Levels implements Serializable {

	public static final long serialVersionUID = 7592951394733899776L;
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

	public RoleTypeIn3Levels(GenericValue value) {
		topRoleTypeId = (String) value.get(FIELD_TOP_ROLE_TYPE_ID);
		topDescription = (String) value.get(FIELD_TOP_DESCRIPTION);
		midRoleTypeId = (String) value.get(FIELD_MID_ROLE_TYPE_ID);
		midDescription = (String) value.get(FIELD_MID_DESCRIPTION);
		lowRoleTypeId = (String) value.get(FIELD_LOW_ROLE_TYPE_ID);
		lowDescription = (String) value.get(FIELD_LOW_DESCRIPTION);
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