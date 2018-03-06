package org.apache.ofbiz.entity.synchronization.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Include Group
 */
public class EntitySyncIncludeGroup implements Serializable {

	public static final long serialVersionUID = 2608990637752655872L;
	public static final String NAME = "EntitySyncIncludeGroup";
	/**
	 * Entity Sync Id
	 */
	@Getter
	@Setter
	private String entitySyncId;
	/**
	 * Entity Group Id
	 */
	@Getter
	@Setter
	private String entityGroupId;

	public enum Fields {
		entitySyncId, entityGroupId
	}

	public EntitySyncIncludeGroup(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
	}

	public static EntitySyncIncludeGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntitySyncIncludeGroup(value);
	}

	public static List<EntitySyncIncludeGroup> fromValues(
			List<GenericValue> values) {
		List<EntitySyncIncludeGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntitySyncIncludeGroup(value));
		}
		return entities;
	}
}