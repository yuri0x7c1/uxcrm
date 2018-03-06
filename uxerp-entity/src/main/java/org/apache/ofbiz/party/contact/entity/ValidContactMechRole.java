package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Valid Contact Mech Role
 */
public class ValidContactMechRole implements Serializable {

	public static final long serialVersionUID = 2721240437629928448L;
	public static final String NAME = "ValidContactMechRole";
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;

	public enum Fields {
		roleTypeId, contactMechTypeId
	}

	public ValidContactMechRole(GenericValue value) {
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
	}

	public static ValidContactMechRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ValidContactMechRole(value);
	}

	public static List<ValidContactMechRole> fromValues(
			List<GenericValue> values) {
		List<ValidContactMechRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ValidContactMechRole(value));
		}
		return entities;
	}
}