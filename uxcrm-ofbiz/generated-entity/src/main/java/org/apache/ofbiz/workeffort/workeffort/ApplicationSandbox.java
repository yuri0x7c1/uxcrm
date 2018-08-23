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
 * Application Sandbox
 */
@FieldNameConstants
public class ApplicationSandbox implements Serializable {

	public static final long serialVersionUID = 5768318672631525376L;
	public static final String NAME = "ApplicationSandbox";
	/**
	 * Application Id
	 */
	@Getter
	@Setter
	private String applicationId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
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

	public ApplicationSandbox(GenericValue value) {
		applicationId = (String) value.get(FIELD_APPLICATION_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		runtimeDataId = (String) value.get(FIELD_RUNTIME_DATA_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ApplicationSandbox fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ApplicationSandbox(value);
	}

	public static List<ApplicationSandbox> fromValues(List<GenericValue> values) {
		List<ApplicationSandbox> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ApplicationSandbox(value));
		}
		return entities;
	}
}