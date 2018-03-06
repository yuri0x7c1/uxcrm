package org.apache.ofbiz.workeffort.workeffort.entity;

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

	public static final long serialVersionUID = 1361634704313522176L;
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

	public enum Fields {
		workEffortId, statusId, statusDatetime, setByUserLogin, reason
	}

	public WorkEffortStatus(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDatetime = (Timestamp) value.get(Fields.statusDatetime.name());
		setByUserLogin = (String) value.get(Fields.setByUserLogin.name());
		reason = (String) value.get(Fields.reason.name());
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