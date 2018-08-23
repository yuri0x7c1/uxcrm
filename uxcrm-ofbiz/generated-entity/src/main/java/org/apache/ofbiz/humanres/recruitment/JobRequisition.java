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
 * Job Requisition
 */
@FieldNameConstants
public class JobRequisition implements Serializable {

	public static final long serialVersionUID = 8498591327246141440L;
	public static final String NAME = "JobRequisition";
	/**
	 * Job Requisition Id
	 */
	@Getter
	@Setter
	private String jobRequisitionId;
	/**
	 * Duration Months
	 */
	@Getter
	@Setter
	private Long durationMonths;
	/**
	 * Age
	 */
	@Getter
	@Setter
	private Long age;
	/**
	 * Gender
	 */
	@Getter
	@Setter
	private String gender;
	/**
	 * Experience Months
	 */
	@Getter
	@Setter
	private Long experienceMonths;
	/**
	 * Experience Years
	 */
	@Getter
	@Setter
	private Long experienceYears;
	/**
	 * Qualification
	 */
	@Getter
	@Setter
	private String qualification;
	/**
	 * Job Location
	 */
	@Getter
	@Setter
	private String jobLocation;
	/**
	 * Skill Type Id
	 */
	@Getter
	@Setter
	private String skillTypeId;
	/**
	 * No Of Resources
	 */
	@Getter
	@Setter
	private Long noOfResources;
	/**
	 * Job Posting Type Enum Id
	 */
	@Getter
	@Setter
	private String jobPostingTypeEnumId;
	/**
	 * Job Requisition Date
	 */
	@Getter
	@Setter
	private Date jobRequisitionDate;
	/**
	 * Exam Type Enum Id
	 */
	@Getter
	@Setter
	private String examTypeEnumId;
	/**
	 * Required On Date
	 */
	@Getter
	@Setter
	private Date requiredOnDate;
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

	public JobRequisition(GenericValue value) {
		jobRequisitionId = (String) value.get(FIELD_JOB_REQUISITION_ID);
		durationMonths = (Long) value.get(FIELD_DURATION_MONTHS);
		age = (Long) value.get(FIELD_AGE);
		gender = (String) value.get(FIELD_GENDER);
		experienceMonths = (Long) value.get(FIELD_EXPERIENCE_MONTHS);
		experienceYears = (Long) value.get(FIELD_EXPERIENCE_YEARS);
		qualification = (String) value.get(FIELD_QUALIFICATION);
		jobLocation = (String) value.get(FIELD_JOB_LOCATION);
		skillTypeId = (String) value.get(FIELD_SKILL_TYPE_ID);
		noOfResources = (Long) value.get(FIELD_NO_OF_RESOURCES);
		jobPostingTypeEnumId = (String) value
				.get(FIELD_JOB_POSTING_TYPE_ENUM_ID);
		jobRequisitionDate = (Date) value.get(FIELD_JOB_REQUISITION_DATE);
		examTypeEnumId = (String) value.get(FIELD_EXAM_TYPE_ENUM_ID);
		requiredOnDate = (Date) value.get(FIELD_REQUIRED_ON_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static JobRequisition fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JobRequisition(value);
	}

	public static List<JobRequisition> fromValues(List<GenericValue> values) {
		List<JobRequisition> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JobRequisition(value));
		}
		return entities;
	}
}