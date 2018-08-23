package org.apache.ofbiz.entity.synchronization;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Incl Grp Detail View
 */
@FieldNameConstants
public class EntitySyncInclGrpDetailView implements Serializable {

	public static final long serialVersionUID = 798934219654779904L;
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

	public EntitySyncInclGrpDetailView(GenericValue value) {
		entitySyncId = (String) value.get(FIELD_ENTITY_SYNC_ID);
		entityGroupId = (String) value.get(FIELD_ENTITY_GROUP_ID);
		entityOrPackage = (String) value.get(FIELD_ENTITY_OR_PACKAGE);
		applEnumId = (String) value.get(FIELD_APPL_ENUM_ID);
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