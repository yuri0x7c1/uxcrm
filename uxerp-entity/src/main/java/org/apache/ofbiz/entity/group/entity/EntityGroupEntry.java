package org.apache.ofbiz.entity.group.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Group Entry
 */
public class EntityGroupEntry implements Serializable {

	public static final long serialVersionUID = 2189193632926051328L;
	public static final String NAME = "EntityGroupEntry";
	/**
	 * Entity Group Id
	 */
	@Getter
	@Setter
	private String entityGroupId;
	/**
	 * Entity Or Package
	 */
	@Getter
	@Setter
	private String entityOrPackage;
	/**
	 * Appl Enum Id
	 */
	@Getter
	@Setter
	private String applEnumId;

	public enum Fields {
		entityGroupId, entityOrPackage, applEnumId
	}

	public EntityGroupEntry(GenericValue value) {
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
		entityOrPackage = (String) value.get(Fields.entityOrPackage.name());
		applEnumId = (String) value.get(Fields.applEnumId.name());
	}

	public static EntityGroupEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntityGroupEntry(value);
	}

	public static List<EntityGroupEntry> fromValues(List<GenericValue> values) {
		List<EntityGroupEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntityGroupEntry(value));
		}
		return entities;
	}
}