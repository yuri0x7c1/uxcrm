package org.apache.ofbiz.entity.group.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Group
 */
public class EntityGroup implements Serializable {

	public static final long serialVersionUID = 7782547524376593408L;
	public static final String NAME = "EntityGroup";
	/**
	 * Entity Group Id
	 */
	@Getter
	@Setter
	private String entityGroupId;
	/**
	 * Entity Group Name
	 */
	@Getter
	@Setter
	private String entityGroupName;

	public enum Fields {
		entityGroupId, entityGroupName
	}

	public EntityGroup(GenericValue value) {
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
		entityGroupName = (String) value.get(Fields.entityGroupName.name());
	}

	public static EntityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntityGroup(value);
	}

	public static List<EntityGroup> fromValues(List<GenericValue> values) {
		List<EntityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntityGroup(value));
		}
		return entities;
	}
}