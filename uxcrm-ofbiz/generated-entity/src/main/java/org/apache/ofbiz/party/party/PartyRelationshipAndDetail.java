package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Relationship And Detail
 */
public class PartyRelationshipAndDetail implements Serializable {

	public static final long serialVersionUID = 7089506651694239744L;
	public static final String NAME = "PartyRelationshipAndDetail";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Party Status Id
	 */
	@Getter
	@Setter
	private String partyStatusId;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * First Name Local
	 */
	@Getter
	@Setter
	private String firstNameLocal;
	/**
	 * Last Name Local
	 */
	@Getter
	@Setter
	private String lastNameLocal;
	/**
	 * Personal Title
	 */
	@Getter
	@Setter
	private String personalTitle;
	/**
	 * Suffix
	 */
	@Getter
	@Setter
	private String suffix;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Group Name Local
	 */
	@Getter
	@Setter
	private String groupNameLocal;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Position Title
	 */
	@Getter
	@Setter
	private String positionTitle;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Priority Type Id
	 */
	@Getter
	@Setter
	private String priorityTypeId;
	/**
	 * Permissions Enum Id
	 */
	@Getter
	@Setter
	private String permissionsEnumId;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Relationship Name
	 */
	@Getter
	@Setter
	private String relationshipName;
	/**
	 * Security Group Id
	 */
	@Getter
	@Setter
	private String securityGroupId;
	/**
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;

	public enum Fields {
		partyId, partyTypeId, description, partyStatusId, firstName, middleName, lastName, firstNameLocal, lastNameLocal, personalTitle, suffix, groupName, groupNameLocal, roleTypeIdTo, partyIdFrom, positionTitle, comments, priorityTypeId, permissionsEnumId, roleTypeIdFrom, thruDate, fromDate, relationshipName, securityGroupId, partyRelationshipTypeId, statusId, partyIdTo
	}

	public PartyRelationshipAndDetail(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		description = (String) value.get(Fields.description.name());
		partyStatusId = (String) value.get(Fields.partyStatusId.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		firstNameLocal = (String) value.get(Fields.firstNameLocal.name());
		lastNameLocal = (String) value.get(Fields.lastNameLocal.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		suffix = (String) value.get(Fields.suffix.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		positionTitle = (String) value.get(Fields.positionTitle.name());
		comments = (String) value.get(Fields.comments.name());
		priorityTypeId = (String) value.get(Fields.priorityTypeId.name());
		permissionsEnumId = (String) value.get(Fields.permissionsEnumId.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		relationshipName = (String) value.get(Fields.relationshipName.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
	}

	public static PartyRelationshipAndDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRelationshipAndDetail(value);
	}

	public static List<PartyRelationshipAndDetail> fromValues(
			List<GenericValue> values) {
		List<PartyRelationshipAndDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRelationshipAndDetail(value));
		}
		return entities;
	}
}