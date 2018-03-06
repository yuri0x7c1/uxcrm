package org.apache.ofbiz.scrum.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Scrum Person And Company And Security Group
 */
public class ScrumPersonAndCompanyAndSecurityGroup implements Serializable {

	public static final long serialVersionUID = 8355641103330711552L;
	public static final String NAME = "ScrumPersonAndCompanyAndSecurityGroup";
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
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
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
	/**
	 * Enabled
	 */
	@Getter
	@Setter
	private String enabled;

	public enum Fields {
		partyId, statusId, groupId, fromDate, thruDate, lastName, middleName, firstName, groupName, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, partyRelationshipTypeId, userLoginId, enabled
	}

	public ScrumPersonAndCompanyAndSecurityGroup(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		statusId = (String) value.get(Fields.statusId.name());
		groupId = (String) value.get(Fields.groupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastName = (String) value.get(Fields.lastName.name());
		middleName = (String) value.get(Fields.middleName.name());
		firstName = (String) value.get(Fields.firstName.name());
		groupName = (String) value.get(Fields.groupName.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		enabled = (String) value.get(Fields.enabled.name());
	}

	public static ScrumPersonAndCompanyAndSecurityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ScrumPersonAndCompanyAndSecurityGroup(value);
	}

	public static List<ScrumPersonAndCompanyAndSecurityGroup> fromValues(
			List<GenericValue> values) {
		List<ScrumPersonAndCompanyAndSecurityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ScrumPersonAndCompanyAndSecurityGroup(value));
		}
		return entities;
	}
}