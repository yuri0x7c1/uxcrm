package org.apache.ofbiz.entity.group;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Group Entry
 */
@FieldNameConstants
public class EntityGroupEntry implements Serializable {

	public static final long serialVersionUID = 1495954423238912000L;
	public static final String NAME = "EntityGroupEntry";
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

	public EntityGroupEntry(GenericValue value) {
		entityGroupId = (String) value.get(FIELD_ENTITY_GROUP_ID);
		entityOrPackage = (String) value.get(FIELD_ENTITY_OR_PACKAGE);
		applEnumId = (String) value.get(FIELD_APPL_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EntityGroupEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntityGroupEntry(value);
	}

	public static List<EntityGroupEntry> fromValues(List<GenericValue> values) {
		List<EntityGroupEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntityGroupEntry(value));
		}
		return entities;
	}
}