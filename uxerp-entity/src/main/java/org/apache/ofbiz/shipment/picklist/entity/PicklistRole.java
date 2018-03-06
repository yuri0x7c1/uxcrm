package org.apache.ofbiz.shipment.picklist.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist Role
 */
public class PicklistRole implements Serializable {

	public static final long serialVersionUID = 3353918729235885056L;
	public static final String NAME = "PicklistRole";
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
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
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;

	public enum Fields {
		picklistId, partyId, roleTypeId, fromDate, thruDate, createdByUserLogin, lastModifiedByUserLogin
	}

	public PicklistRole(GenericValue value) {
		picklistId = (String) value.get(Fields.picklistId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
	}

	public static PicklistRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PicklistRole(value);
	}

	public static List<PicklistRole> fromValues(List<GenericValue> values) {
		List<PicklistRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PicklistRole(value));
		}
		return entities;
	}
}