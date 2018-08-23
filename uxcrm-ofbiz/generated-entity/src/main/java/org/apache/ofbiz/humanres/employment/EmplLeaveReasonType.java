package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Leave Reason Type
 */
@FieldNameConstants
public class EmplLeaveReasonType implements Serializable {

	public static final long serialVersionUID = 2688187498885928960L;
	public static final String NAME = "EmplLeaveReasonType";
	/**
	 * Empl Leave Reason Type Id
	 */
	@Getter
	@Setter
	private String emplLeaveReasonTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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

	public EmplLeaveReasonType(GenericValue value) {
		emplLeaveReasonTypeId = (String) value
				.get(FIELD_EMPL_LEAVE_REASON_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EmplLeaveReasonType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplLeaveReasonType(value);
	}

	public static List<EmplLeaveReasonType> fromValues(List<GenericValue> values) {
		List<EmplLeaveReasonType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplLeaveReasonType(value));
		}
		return entities;
	}
}