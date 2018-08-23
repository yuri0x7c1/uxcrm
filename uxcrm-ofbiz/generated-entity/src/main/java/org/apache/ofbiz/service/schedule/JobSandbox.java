package org.apache.ofbiz.service.schedule;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Job Sandbox
 */
@FieldNameConstants
public class JobSandbox implements Serializable {

	public static final long serialVersionUID = 5149358072920120320L;
	public static final String NAME = "JobSandbox";
	/**
	 * Job Id
	 */
	@Getter
	@Setter
	private String jobId;
	/**
	 * Job Name
	 */
	@Getter
	@Setter
	private String jobName;
	/**
	 * Run Time
	 */
	@Getter
	@Setter
	private Timestamp runTime;
	/**
	 * Pool Id
	 */
	@Getter
	@Setter
	private String poolId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Parent Job Id
	 */
	@Getter
	@Setter
	private String parentJobId;
	/**
	 * Previous Job Id
	 */
	@Getter
	@Setter
	private String previousJobId;
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Loader Name
	 */
	@Getter
	@Setter
	private String loaderName;
	/**
	 * Max Retry
	 */
	@Getter
	@Setter
	private Long maxRetry;
	/**
	 * Current Retry Count
	 */
	@Getter
	@Setter
	private Long currentRetryCount;
	/**
	 * Auth User Login Id
	 */
	@Getter
	@Setter
	private String authUserLoginId;
	/**
	 * Run As User
	 */
	@Getter
	@Setter
	private String runAsUser;
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Current Recurrence Count
	 */
	@Getter
	@Setter
	private Long currentRecurrenceCount;
	/**
	 * Max Recurrence Count
	 */
	@Getter
	@Setter
	private Long maxRecurrenceCount;
	/**
	 * Run By Instance Id
	 */
	@Getter
	@Setter
	private String runByInstanceId;
	/**
	 * Start Date Time
	 */
	@Getter
	@Setter
	private Timestamp startDateTime;
	/**
	 * Finish Date Time
	 */
	@Getter
	@Setter
	private Timestamp finishDateTime;
	/**
	 * Cancel Date Time
	 */
	@Getter
	@Setter
	private Timestamp cancelDateTime;
	/**
	 * Job Result
	 */
	@Getter
	@Setter
	private String jobResult;
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

	public JobSandbox(GenericValue value) {
		jobId = (String) value.get(FIELD_JOB_ID);
		jobName = (String) value.get(FIELD_JOB_NAME);
		runTime = (Timestamp) value.get(FIELD_RUN_TIME);
		poolId = (String) value.get(FIELD_POOL_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		parentJobId = (String) value.get(FIELD_PARENT_JOB_ID);
		previousJobId = (String) value.get(FIELD_PREVIOUS_JOB_ID);
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		loaderName = (String) value.get(FIELD_LOADER_NAME);
		maxRetry = (Long) value.get(FIELD_MAX_RETRY);
		currentRetryCount = (Long) value.get(FIELD_CURRENT_RETRY_COUNT);
		authUserLoginId = (String) value.get(FIELD_AUTH_USER_LOGIN_ID);
		runAsUser = (String) value.get(FIELD_RUN_AS_USER);
		runtimeDataId = (String) value.get(FIELD_RUNTIME_DATA_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		tempExprId = (String) value.get(FIELD_TEMP_EXPR_ID);
		currentRecurrenceCount = (Long) value
				.get(FIELD_CURRENT_RECURRENCE_COUNT);
		maxRecurrenceCount = (Long) value.get(FIELD_MAX_RECURRENCE_COUNT);
		runByInstanceId = (String) value.get(FIELD_RUN_BY_INSTANCE_ID);
		startDateTime = (Timestamp) value.get(FIELD_START_DATE_TIME);
		finishDateTime = (Timestamp) value.get(FIELD_FINISH_DATE_TIME);
		cancelDateTime = (Timestamp) value.get(FIELD_CANCEL_DATE_TIME);
		jobResult = (String) value.get(FIELD_JOB_RESULT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static JobSandbox fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JobSandbox(value);
	}

	public static List<JobSandbox> fromValues(List<GenericValue> values) {
		List<JobSandbox> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JobSandbox(value));
		}
		return entities;
	}
}