package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Role
 */
public class DataResourceRole implements Serializable {

	public static final long serialVersionUID = 4586482801673014272L;
	public static final String NAME = "DataResourceRole";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
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
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		dataResourceId, partyId, roleTypeId, fromDate, thruDate
	}

	public DataResourceRole(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static DataResourceRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceRole(value);
	}

	public static List<DataResourceRole> fromValues(List<GenericValue> values) {
		List<DataResourceRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceRole(value));
		}
		return entities;
	}
}