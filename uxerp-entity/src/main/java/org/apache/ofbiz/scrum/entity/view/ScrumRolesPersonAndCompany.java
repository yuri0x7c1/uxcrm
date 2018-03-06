package org.apache.ofbiz.scrum.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Scrum Roles Person And Company
 */
public class ScrumRolesPersonAndCompany implements Serializable {

	public static final long serialVersionUID = 343010071145604096L;
	public static final String NAME = "ScrumRolesPersonAndCompany";
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
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
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
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public enum Fields {
		partyId, roleTypeId, firstName, lastName, middleName, parentTypeId, partyIdFrom, roleTypeIdFrom, roleTypeIdTo, fromDate, thruDate, groupName, description, statusId
	}

	public ScrumRolesPersonAndCompany(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		firstName = (String) value.get(Fields.firstName.name());
		lastName = (String) value.get(Fields.lastName.name());
		middleName = (String) value.get(Fields.middleName.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		groupName = (String) value.get(Fields.groupName.name());
		description = (String) value.get(Fields.description.name());
		statusId = (String) value.get(Fields.statusId.name());
	}

	public static ScrumRolesPersonAndCompany fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ScrumRolesPersonAndCompany(value);
	}

	public static List<ScrumRolesPersonAndCompany> fromValues(
			List<GenericValue> values) {
		List<ScrumRolesPersonAndCompany> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ScrumRolesPersonAndCompany(value));
		}
		return entities;
	}
}