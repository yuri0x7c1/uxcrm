package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type And Party
 */
@FieldNameConstants
public class RoleTypeAndParty implements Serializable {

	public static final long serialVersionUID = 940468586130714624L;
	public static final String NAME = "RoleTypeAndParty";
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
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public RoleTypeAndParty(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
	}

	public static RoleTypeAndParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RoleTypeAndParty(value);
	}

	public static List<RoleTypeAndParty> fromValues(List<GenericValue> values) {
		List<RoleTypeAndParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RoleTypeAndParty(value));
		}
		return entities;
	}
}