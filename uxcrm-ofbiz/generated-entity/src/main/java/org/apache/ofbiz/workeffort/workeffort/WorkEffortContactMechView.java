package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Contact Mech View
 */
@FieldNameConstants
public class WorkEffortContactMechView implements Serializable {

	public static final long serialVersionUID = 7664129665933007872L;
	public static final String NAME = "WorkEffortContactMechView";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;

	public WorkEffortContactMechView(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		infoString = (String) value.get(FIELD_INFO_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
	}

	public static WorkEffortContactMechView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortContactMechView(value);
	}

	public static List<WorkEffortContactMechView> fromValues(
			List<GenericValue> values) {
		List<WorkEffortContactMechView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortContactMechView(value));
		}
		return entities;
	}
}