package org.apache.ofbiz.humanres.recruitment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Job Requisition
 */
public class JobRequisition implements Serializable {

	public static final long serialVersionUID = 2477105288917332992L;
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

	public enum Fields {
		jobRequisitionId, durationMonths, age, gender, experienceMonths, experienceYears, qualification, jobLocation, skillTypeId, noOfResources, jobPostingTypeEnumId, jobRequisitionDate, examTypeEnumId, requiredOnDate
	}

	public JobRequisition(GenericValue value) {
		jobRequisitionId = (String) value.get(Fields.jobRequisitionId.name());
		durationMonths = (Long) value.get(Fields.durationMonths.name());
		age = (Long) value.get(Fields.age.name());
		gender = (String) value.get(Fields.gender.name());
		experienceMonths = (Long) value.get(Fields.experienceMonths.name());
		experienceYears = (Long) value.get(Fields.experienceYears.name());
		qualification = (String) value.get(Fields.qualification.name());
		jobLocation = (String) value.get(Fields.jobLocation.name());
		skillTypeId = (String) value.get(Fields.skillTypeId.name());
		noOfResources = (Long) value.get(Fields.noOfResources.name());
		jobPostingTypeEnumId = (String) value.get(Fields.jobPostingTypeEnumId
				.name());
		jobRequisitionDate = (Date) value.get(Fields.jobRequisitionDate.name());
		examTypeEnumId = (String) value.get(Fields.examTypeEnumId.name());
		requiredOnDate = (Date) value.get(Fields.requiredOnDate.name());
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