package org.apache.ofbiz.party.party.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type And Party
 */
public class RoleTypeAndParty implements Serializable {

	public static final long serialVersionUID = 4080409163782447104L;
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

	public enum Fields {
		partyId, roleTypeId, parentTypeId, description
	}

	public RoleTypeAndParty(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
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