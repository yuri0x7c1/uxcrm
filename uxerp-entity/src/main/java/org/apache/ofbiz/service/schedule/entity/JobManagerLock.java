package org.apache.ofbiz.service.schedule.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Job Manager Lock
 */
public class JobManagerLock implements Serializable {

	public static final long serialVersionUID = 7616663253004048384L;
	public static final String NAME = "JobManagerLock";
	/**
	 * Instance Id
	 */
	@Getter
	@Setter
	private String instanceId;
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
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;

	public enum Fields {
		instanceId, fromDate, thruDate, reasonEnumId, comments, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public JobManagerLock(GenericValue value) {
		instanceId = (String) value.get(Fields.instanceId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
		comments = (String) value.get(Fields.comments.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
	}

	public static JobManagerLock fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JobManagerLock(value);
	}

	public static List<JobManagerLock> fromValues(List<GenericValue> values) {
		List<JobManagerLock> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JobManagerLock(value));
		}
		return entities;
	}
}