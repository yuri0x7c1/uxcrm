package org.apache.ofbiz.entity.group;

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
public class EntityGroup implements Serializable {

	public static final long serialVersionUID = 2673689932711603200L;
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

	public enum Fields {
		entityGroupId, entityGroupName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntityGroup(GenericValue value) {
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
		entityGroupName = (String) value.get(Fields.entityGroupName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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