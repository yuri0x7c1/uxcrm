package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Priority Type
 */
public class PriorityType implements Serializable {

	public static final long serialVersionUID = 695809971033074688L;
	public static final String NAME = "PriorityType";
	/**
	 * Priority Type Id
	 */
	@Getter
	@Setter
	private String priorityTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		priorityTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PriorityType(GenericValue value) {
		priorityTypeId = (String) value.get(Fields.priorityTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PriorityType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PriorityType(value);
	}

	public static List<PriorityType> fromValues(List<GenericValue> values) {
		List<PriorityType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PriorityType(value));
		}
		return entities;
	}
}