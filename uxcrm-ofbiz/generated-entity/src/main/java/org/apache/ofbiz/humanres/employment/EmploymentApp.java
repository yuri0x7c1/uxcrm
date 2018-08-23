package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EmploymentApp implements Serializable {

	public static final long serialVersionUID = 5299659893592716288L;
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

	public EmploymentApp(GenericValue value) {
		applicationId = (String) value.get(FIELD_APPLICATION_ID);
		emplPositionId = (String) value.get(FIELD_EMPL_POSITION_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		employmentAppSourceTypeId = (String) value
				.get(FIELD_EMPLOYMENT_APP_SOURCE_TYPE_ID);
		applyingPartyId = (String) value.get(FIELD_APPLYING_PARTY_ID);
		referredByPartyId = (String) value.get(FIELD_REFERRED_BY_PARTY_ID);
		applicationDate = (Timestamp) value.get(FIELD_APPLICATION_DATE);
		approverPartyId = (String) value.get(FIELD_APPROVER_PARTY_ID);
		jobRequisitionId = (String) value.get(FIELD_JOB_REQUISITION_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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