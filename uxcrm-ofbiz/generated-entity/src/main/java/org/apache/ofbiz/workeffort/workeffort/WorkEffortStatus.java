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
 * Work Effort Status
 */
@FieldNameConstants
public class WorkEffortStatus implements Serializable {

	public static final long serialVersionUID = 3060861199125180416L;
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

	public WorkEffortStatus(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDatetime = (Timestamp) value.get(FIELD_STATUS_DATETIME);
		setByUserLogin = (String) value.get(FIELD_SET_BY_USER_LOGIN);
		reason = (String) value.get(FIELD_REASON);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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