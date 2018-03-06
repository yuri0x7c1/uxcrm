package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type Attr
 */
public class RoleTypeAttr implements Serializable {

	public static final long serialVersionUID = 3326445468298200064L;
	public static final String NAME = "RoleTypeAttr";
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		roleTypeId, attrName, description
	}

	public RoleTypeAttr(GenericValue value) {
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RoleTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RoleTypeAttr(value);
	}

	public static List<RoleTypeAttr> fromValues(List<GenericValue> values) {
		List<RoleTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RoleTypeAttr(value));
		}
		return entities;
	}
}