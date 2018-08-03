package org.apache.ofbiz.humanres.employment;

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

	public static final long serialVersionUID = 3325448358316377088L;
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
		applicationId, emplPositionId, statusId, employmentAppSourceTypeId, applyingPartyId, referredByPartyId, applicationDate, approverPartyId, jobRequisitionId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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