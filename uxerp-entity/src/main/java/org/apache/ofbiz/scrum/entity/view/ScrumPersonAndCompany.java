package org.apache.ofbiz.scrum.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Scrum Person And Company
 */
public class ScrumPersonAndCompany implements Serializable {

	public static final long serialVersionUID = 3869424200262124544L;
	public static final String NAME = "ScrumPersonAndCompany";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
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
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;

	public enum Fields {
		partyId, statusId, lastName, middleName, firstName, groupName, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, fromDate, thruDate, partyRelationshipTypeId, userLoginId
	}

	public ScrumPersonAndCompany(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		statusId = (String) value.get(Fields.statusId.name());
		lastName = (String) value.get(Fields.lastName.name());
		middleName = (String) value.get(Fields.middleName.name());
		firstName = (String) value.get(Fields.firstName.name());
		groupName = (String) value.get(Fields.groupName.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
	}

	public static ScrumPersonAndCompany fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ScrumPersonAndCompany(value);
	}

	public static List<ScrumPersonAndCompany> fromValues(
			List<GenericValue> values) {
		List<ScrumPersonAndCompany> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ScrumPersonAndCompany(value));
		}
		return entities;
	}
}