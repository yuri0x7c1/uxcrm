package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PriorityType implements Serializable {

	public static final long serialVersionUID = 8342738959122392064L;
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

	public PriorityType(GenericValue value) {
		priorityTypeId = (String) value.get(FIELD_PRIORITY_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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