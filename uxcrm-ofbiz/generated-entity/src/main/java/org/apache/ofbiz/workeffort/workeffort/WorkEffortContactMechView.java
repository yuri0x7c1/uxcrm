package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortContactMechView implements Serializable {

	public static final long serialVersionUID = 4137150067389986816L;
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

	public enum Fields {
		workEffortId, fromDate, comments, contactMechId, thruDate, infoString, contactMechTypeId
	}

	public WorkEffortContactMechView(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		comments = (String) value.get(Fields.comments.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		infoString = (String) value.get(Fields.infoString.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
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