package org.apache.ofbiz.entity.synchronization;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EntitySyncIncludeGroup implements Serializable {

	public static final long serialVersionUID = 4206714633727052800L;
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

	public EntitySyncIncludeGroup(GenericValue value) {
		entitySyncId = (String) value.get(FIELD_ENTITY_SYNC_ID);
		entityGroupId = (String) value.get(FIELD_ENTITY_GROUP_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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