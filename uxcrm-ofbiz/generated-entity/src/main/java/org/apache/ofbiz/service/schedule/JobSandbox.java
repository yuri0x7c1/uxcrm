package org.apache.ofbiz.service.schedule;

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
public class JobSandbox implements Serializable {

	public static final long serialVersionUID = 2895252387703705600L;
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

	public enum Fields {
		jobId, jobName, runTime, poolId, statusId, parentJobId, previousJobId, serviceName, loaderName, maxRetry, currentRetryCount, authUserLoginId, runAsUser, runtimeDataId, recurrenceInfoId, tempExprId, currentRecurrenceCount, maxRecurrenceCount, runByInstanceId, startDateTime, finishDateTime, cancelDateTime, jobResult, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public JobSandbox(GenericValue value) {
		jobId = (String) value.get(Fields.jobId.name());
		jobName = (String) value.get(Fields.jobName.name());
		runTime = (Timestamp) value.get(Fields.runTime.name());
		poolId = (String) value.get(Fields.poolId.name());
		statusId = (String) value.get(Fields.statusId.name());
		parentJobId = (String) value.get(Fields.parentJobId.name());
		previousJobId = (String) value.get(Fields.previousJobId.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		loaderName = (String) value.get(Fields.loaderName.name());
		maxRetry = (Long) value.get(Fields.maxRetry.name());
		currentRetryCount = (Long) value.get(Fields.currentRetryCount.name());
		authUserLoginId = (String) value.get(Fields.authUserLoginId.name());
		runAsUser = (String) value.get(Fields.runAsUser.name());
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		tempExprId = (String) value.get(Fields.tempExprId.name());
		currentRecurrenceCount = (Long) value.get(Fields.currentRecurrenceCount
				.name());
		maxRecurrenceCount = (Long) value.get(Fields.maxRecurrenceCount.name());
		runByInstanceId = (String) value.get(Fields.runByInstanceId.name());
		startDateTime = (Timestamp) value.get(Fields.startDateTime.name());
		finishDateTime = (Timestamp) value.get(Fields.finishDateTime.name());
		cancelDateTime = (Timestamp) value.get(Fields.cancelDateTime.name());
		jobResult = (String) value.get(Fields.jobResult.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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