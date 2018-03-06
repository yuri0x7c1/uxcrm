package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Employment App
 */
public class EmploymentApp implements Serializable {

	public static final long serialVersionUID = 5119174602309211136L;
	public static final String NAME = "EmploymentApp";
	/**
	 * Application Id
	 */
	@Getter
	@Setter
	private String applicationId;
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Employment App Source Type Id
	 */
	@Getter
	@Setter
	private String employmentAppSourceTypeId;
	/**
	 * Applying Party Id
	 */
	@Getter
	@Setter
	private String applyingPartyId;
	/**
	 * Referred By Party Id
	 */
	@Getter
	@Setter
	private String referredByPartyId;
	/**
	 * Application Date
	 */
	@Getter
	@Setter
	private Timestamp applicationDate;
	/**
	 * Approver Party Id
	 */
	@Getter
	@Setter
	private String approverPartyId;
	/**
	 * Job Requisition Id
	 */
	@Getter
	@Setter
	private String jobRequisitionId;

	public enum Fields {
		applicationId, emplPositionId, statusId, employmentAppSourceTypeId, applyingPartyId, referredByPartyId, applicationDate, approverPartyId, jobRequisitionId
	}

	public EmploymentApp(GenericValue value) {
		applicationId = (String) value.get(Fields.applicationId.name());
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		statusId = (String) value.get(Fields.statusId.name());
		employmentAppSourceTypeId = (String) value
				.get(Fields.employmentAppSourceTypeId.name());
		applyingPartyId = (String) value.get(Fields.applyingPartyId.name());
		referredByPartyId = (String) value.get(Fields.referredByPartyId.name());
		applicationDate = (Timestamp) value.get(Fields.applicationDate.name());
		approverPartyId = (String) value.get(Fields.approverPartyId.name());
		jobRequisitionId = (String) value.get(Fields.jobRequisitionId.name());
	}

	public static EmploymentApp fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmploymentApp(value);
	}

	public static List<EmploymentApp> fromValues(List<GenericValue> values) {
		List<EmploymentApp> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmploymentApp(value));
		}
		return entities;
	}
}