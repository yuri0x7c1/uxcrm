package org.apache.ofbiz.entity.synchronization.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Remove
 */
public class EntitySyncRemove implements Serializable {

	public static final long serialVersionUID = 7723422738998221824L;
	public static final String NAME = "EntitySyncRemove";
	/**
	 * Entity Sync Remove Id
	 */
	@Getter
	@Setter
	private String entitySyncRemoveId;
	/**
	 * Primary Key Removed
	 */
	@Getter
	@Setter
	private String primaryKeyRemoved;

	public enum Fields {
		entitySyncRemoveId, primaryKeyRemoved
	}

	public EntitySyncRemove(GenericValue value) {
		entitySyncRemoveId = (String) value.get(Fields.entitySyncRemoveId
				.name());
		primaryKeyRemoved = (String) value.get(Fields.primaryKeyRemoved.name());
	}

	public static EntitySyncRemove fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntitySyncRemove(value);
	}

	public static List<EntitySyncRemove> fromValues(List<GenericValue> values) {
		List<EntitySyncRemove> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntitySyncRemove(value));
		}
		return entities;
	}
}