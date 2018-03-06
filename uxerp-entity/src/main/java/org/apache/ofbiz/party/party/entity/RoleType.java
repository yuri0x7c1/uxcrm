package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Role Type
 */
public class RoleType implements Serializable {

	public static final long serialVersionUID = 5186320616920677376L;
	public static final String NAME = "RoleType";
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
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		roleTypeId, parentTypeId, hasTable, description
	}

	public RoleType(GenericValue value) {
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RoleType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new RoleType(value);
	}

	public static List<RoleType> fromValues(List<GenericValue> values) {
		List<RoleType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RoleType(value));
		}
		return entities;
	}
}