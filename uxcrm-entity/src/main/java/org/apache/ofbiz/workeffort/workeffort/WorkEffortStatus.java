package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Status
 */
public class WorkEffortStatus implements Serializable {

	public static final long serialVersionUID = 8396009893803792384L;
	public static final String NAME = "WorkEffortStatus";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Datetime
	 */
	@Getter
	@Setter
	private Timestamp statusDatetime;
	/**
	 * Set By User Login
	 */
	@Getter
	@Setter
	private String setByUserLogin;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
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
		workEffortId, statusId, statusDatetime, setByUserLogin, reason, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortStatus(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDatetime = (Timestamp) value.get(Fields.statusDatetime.name());
		setByUserLogin = (String) value.get(Fields.setByUserLogin.name());
		reason = (String) value.get(Fields.reason.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortStatus(value);
	}

	public static List<WorkEffortStatus> fromValues(List<GenericValue> values) {
		List<WorkEffortStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortStatus(value));
		}
		return entities;
	}
}