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
 * Entity Sync Remove
 */
@FieldNameConstants
public class EntitySyncRemove implements Serializable {

	public static final long serialVersionUID = 8249638461042782208L;
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

	public EntitySyncRemove(GenericValue value) {
		entitySyncRemoveId = (String) value.get(FIELD_ENTITY_SYNC_REMOVE_ID);
		primaryKeyRemoved = (String) value.get(FIELD_PRIMARY_KEY_REMOVED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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