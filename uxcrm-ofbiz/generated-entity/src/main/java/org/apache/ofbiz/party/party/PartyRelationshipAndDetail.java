package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyRelationshipAndDetail implements Serializable {

	public static final long serialVersionUID = 6439526561404759040L;
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

	public PartyRelationshipAndDetail(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		partyStatusId = (String) value.get(FIELD_PARTY_STATUS_ID);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		firstNameLocal = (String) value.get(FIELD_FIRST_NAME_LOCAL);
		lastNameLocal = (String) value.get(FIELD_LAST_NAME_LOCAL);
		personalTitle = (String) value.get(FIELD_PERSONAL_TITLE);
		suffix = (String) value.get(FIELD_SUFFIX);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		positionTitle = (String) value.get(FIELD_POSITION_TITLE);
		comments = (String) value.get(FIELD_COMMENTS);
		priorityTypeId = (String) value.get(FIELD_PRIORITY_TYPE_ID);
		permissionsEnumId = (String) value.get(FIELD_PERMISSIONS_ENUM_ID);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		relationshipName = (String) value.get(FIELD_RELATIONSHIP_NAME);
		securityGroupId = (String) value.get(FIELD_SECURITY_GROUP_ID);
		partyRelationshipTypeId = (String) value
				.get(FIELD_PARTY_RELATIONSHIP_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
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