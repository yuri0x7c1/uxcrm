package org.apache.ofbiz.entity.synchronization;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync Include
 */
public class EntitySyncInclude implements Serializable {

	public static final long serialVersionUID = 6538703693112579072L;
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
		entitySyncId, entityOrPackage, applEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntitySyncInclude(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		entityOrPackage = (String) value.get(Fields.entityOrPackage.name());
		applEnumId = (String) value.get(Fields.applEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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