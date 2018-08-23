package org.apache.ofbiz.humanres.recruitment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Job Interview
 */
@FieldNameConstants
public class JobInterview implements Serializable {

	public static final long serialVersionUID = 8914862494036085760L;
	public static final String NAME = "JobInterview";
	/**
	 * Job Interview Id
	 */
	@Getter
	@Setter
	private String jobInterviewId;
	/**
	 * Job Interviewee Party Id
	 */
	@Getter
	@Setter
	private String jobIntervieweePartyId;
	/**
	 * Job Requisition Id
	 */
	@Getter
	@Setter
	private String jobRequisitionId;
	/**
	 * Job Interviewer Party Id
	 */
	@Getter
	@Setter
	private String jobInterviewerPartyId;
	/**
	 * Job Interview Type Id
	 */
	@Getter
	@Setter
	private String jobInterviewTypeId;
	/**
	 * Grade Secured Enum Id
	 */
	@Getter
	@Setter
	private String gradeSecuredEnumId;
	/**
	 * Job Interview Result
	 */
	@Getter
	@Setter
	private String jobInterviewResult;
	/**
	 * Job Interview Date
	 */
	@Getter
	@Setter
	private Date jobInterviewDate;
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

	public JobInterview(GenericValue value) {
		jobInterviewId = (String) value.get(FIELD_JOB_INTERVIEW_ID);
		jobIntervieweePartyId = (String) value
				.get(FIELD_JOB_INTERVIEWEE_PARTY_ID);
		jobRequisitionId = (String) value.get(FIELD_JOB_REQUISITION_ID);
		jobInterviewerPartyId = (String) value
				.get(FIELD_JOB_INTERVIEWER_PARTY_ID);
		jobInterviewTypeId = (String) value.get(FIELD_JOB_INTERVIEW_TYPE_ID);
		gradeSecuredEnumId = (String) value.get(FIELD_GRADE_SECURED_ENUM_ID);
		jobInterviewResult = (String) value.get(FIELD_JOB_INTERVIEW_RESULT);
		jobInterviewDate = (Date) value.get(FIELD_JOB_INTERVIEW_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static JobInterview fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JobInterview(value);
	}

	public static List<JobInterview> fromValues(List<GenericValue> values) {
		List<JobInterview> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JobInterview(value));
		}
		return entities;
	}
}