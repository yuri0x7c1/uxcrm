package org.apache.ofbiz.entity.synchronization;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Incl Grp Detail View
 */
public class EntitySyncInclGrpDetailView implements Serializable {

	public static final long serialVersionUID = 4273791176048509952L;
	public static final String NAME = "EntitySyncInclGrpDetailView";
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
		entitySyncId, entityGroupId, entityOrPackage, applEnumId
	}

	public EntitySyncInclGrpDetailView(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
		entityOrPackage = (String) value.get(Fields.entityOrPackage.name());
		applEnumId = (String) value.get(Fields.applEnumId.name());
	}

	public static EntitySyncInclGrpDetailView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntitySyncInclGrpDetailView(value);
	}

	public static List<EntitySyncInclGrpDetailView> fromValues(
			List<GenericValue> values) {
		List<EntitySyncInclGrpDetailView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntitySyncInclGrpDetailView(value));
		}
		return entities;
	}
}