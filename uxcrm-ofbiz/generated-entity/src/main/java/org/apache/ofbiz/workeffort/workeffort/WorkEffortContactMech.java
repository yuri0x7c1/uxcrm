package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Contact Mech
 */
public class WorkEffortContactMech implements Serializable {

	public static final long serialVersionUID = 6672268200411330560L;
	public static final String NAME = "WorkEffortContactMech";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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
		workEffortId, contactMechId, fromDate, thruDate, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortContactMech(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortContactMech(value);
	}

	public static List<WorkEffortContactMech> fromValues(
			List<GenericValue> values) {
		List<WorkEffortContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortContactMech(value));
		}
		return entities;
	}
}