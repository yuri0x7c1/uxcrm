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
 * Entity Sync Include
 */
@FieldNameConstants
public class EntitySyncInclude implements Serializable {

	public static final long serialVersionUID = 7512285163802397696L;
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

	public EntitySyncInclude(GenericValue value) {
		entitySyncId = (String) value.get(FIELD_ENTITY_SYNC_ID);
		entityOrPackage = (String) value.get(FIELD_ENTITY_OR_PACKAGE);
		applEnumId = (String) value.get(FIELD_APPL_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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