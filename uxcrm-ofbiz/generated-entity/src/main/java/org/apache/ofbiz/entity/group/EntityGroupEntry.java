package org.apache.ofbiz.entity.group;

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
public class EntityGroupEntry implements Serializable {

	public static final long serialVersionUID = 5993045561250086912L;
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

	public enum Fields {
		entityGroupId, entityOrPackage, applEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntityGroupEntry(GenericValue value) {
		entityGroupId = (String) value.get(Fields.entityGroupId.name());
		entityOrPackage = (String) value.get(Fields.entityOrPackage.name());
		applEnumId = (String) value.get(Fields.applEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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