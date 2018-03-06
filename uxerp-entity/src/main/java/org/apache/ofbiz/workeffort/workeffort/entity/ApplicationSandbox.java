package org.apache.ofbiz.workeffort.workeffort.entity;

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
public class ApplicationSandbox implements Serializable {

	public static final long serialVersionUID = 4846320422467534848L;
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

	public enum Fields {
		applicationId, workEffortId, partyId, roleTypeId, fromDate, runtimeDataId
	}

	public ApplicationSandbox(GenericValue value) {
		applicationId = (String) value.get(Fields.applicationId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
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