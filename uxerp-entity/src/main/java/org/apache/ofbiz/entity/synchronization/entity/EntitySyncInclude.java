package org.apache.ofbiz.entity.synchronization.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Include
 */
public class EntitySyncInclude implements Serializable {

	public static final long serialVersionUID = 343656774810351616L;
	public static final String NAME = "EntitySyncInclude";
	/**
	 * Entity Sync Id
	 */
	@Getter
	@Setter
	private String entitySyncId;
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
		entitySyncId, entityOrPackage, applEnumId
	}

	public EntitySyncInclude(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		entityOrPackage = (String) value.get(Fields.entityOrPackage.name());
		applEnumId = (String) value.get(Fields.applEnumId.name());
	}

	public static EntitySyncInclude fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntitySyncInclude(value);
	}

	public static List<EntitySyncInclude> fromValues(List<GenericValue> values) {
		List<EntitySyncInclude> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntitySyncInclude(value));
		}
		return entities;
	}
}