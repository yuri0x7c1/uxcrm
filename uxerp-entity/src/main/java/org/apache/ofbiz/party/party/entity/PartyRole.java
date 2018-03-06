package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Role
 */
public class PartyRole implements Serializable {

	public static final long serialVersionUID = 6018084701756542976L;
	public static final String NAME = "PartyRole";
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

	public enum Fields {
		partyId, roleTypeId
	}

	public PartyRole(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static PartyRole fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRole(value);
	}

	public static List<PartyRole> fromValues(List<GenericValue> values) {
		List<PartyRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRole(value));
		}
		return entities;
	}
}