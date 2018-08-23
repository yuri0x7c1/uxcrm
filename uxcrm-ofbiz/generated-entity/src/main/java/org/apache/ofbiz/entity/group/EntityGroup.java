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
 * Entity Group
 */
@FieldNameConstants
public class EntityGroup implements Serializable {

	public static final long serialVersionUID = 824602696947227648L;
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

	public EntityGroup(GenericValue value) {
		entityGroupId = (String) value.get(FIELD_ENTITY_GROUP_ID);
		entityGroupName = (String) value.get(FIELD_ENTITY_GROUP_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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