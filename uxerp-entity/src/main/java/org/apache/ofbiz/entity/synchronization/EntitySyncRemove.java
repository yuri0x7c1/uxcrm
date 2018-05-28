package org.apache.ofbiz.entity.synchronization;

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
public class EntitySyncRemove implements Serializable {

	public static final long serialVersionUID = 3010859532809819136L;
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

	public enum Fields {
		entitySyncRemoveId, primaryKeyRemoved, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntitySyncRemove(GenericValue value) {
		entitySyncRemoveId = (String) value.get(Fields.entitySyncRemoveId
				.name());
		primaryKeyRemoved = (String) value.get(Fields.primaryKeyRemoved.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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