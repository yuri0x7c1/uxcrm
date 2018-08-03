package org.apache.ofbiz.entity.synchronization;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Include Group
 */
public class EntitySyncIncludeGroup implements Serializable {

	public static final long serialVersionUID = 1364801853167902720L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		entitySyncId, entityGroupId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntitySyncIncludeGroup(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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