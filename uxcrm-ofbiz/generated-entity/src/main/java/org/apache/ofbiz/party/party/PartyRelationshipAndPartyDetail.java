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
 * Party Relationship And Party Detail
 */
@FieldNameConstants
public class PartyRelationshipAndPartyDetail implements Serializable {

	public static final long serialVersionUID = 2055164542284853248L;
	public static final String NAME = "PartyRelationshipAndPartyDetail";
	/**
	 * Rel Parent Type Id
	 */
	@Getter
	@Setter
	private String relParentTypeId;
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
	 * To First Name
	 */
	@Getter
	@Setter
	private String toFirstName;
	/**
	 * To Middle Name
	 */
	@Getter
	@Setter
	private String toMiddleName;
	/**
	 * To Last Name
	 */
	@Getter
	@Setter
	private String toLastName;
	/**
	 * Tofirst Name Local
	 */
	@Getter
	@Setter
	private String tofirstNameLocal;
	/**
	 * To Last Name Local
	 */
	@Getter
	@Setter
	private String toLastNameLocal;
	/**
	 * To Personal Title
	 */
	@Getter
	@Setter
	private String toPersonalTitle;
	/**
	 * To Suffix
	 */
	@Getter
	@Setter
	private String toSuffix;
	/**
	 * To Group Name
	 */
	@Getter
	@Setter
	private String toGroupName;
	/**
	 * To Group Name Local
	 */
	@Getter
	@Setter
	private String toGroupNameLocal;
	/**
	 * From First Name
	 */
	@Getter
	@Setter
	private String fromFirstName;
	/**
	 * From Middle Name
	 */
	@Getter
	@Setter
	private String fromMiddleName;
	/**
	 * From Last Name
	 */
	@Getter
	@Setter
	private String fromLastName;
	/**
	 * Fromfirst Name Local
	 */
	@Getter
	@Setter
	private String fromfirstNameLocal;
	/**
	 * From Last Name Local
	 */
	@Getter
	@Setter
	private String fromLastNameLocal;
	/**
	 * From Personal Title
	 */
	@Getter
	@Setter
	private String fromPersonalTitle;
	/**
	 * From Suffix
	 */
	@Getter
	@Setter
	private String fromSuffix;
	/**
	 * From Group Name
	 */
	@Getter
	@Setter
	private String fromGroupName;
	/**
	 * From Group Name Local
	 */
	@Getter
	@Setter
	private String fromGroupNameLocal;
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

	public PartyRelationshipAndPartyDetail(GenericValue value) {
		relParentTypeId = (String) value.get(FIELD_REL_PARENT_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		partyStatusId = (String) value.get(FIELD_PARTY_STATUS_ID);
		toFirstName = (String) value.get(FIELD_TO_FIRST_NAME);
		toMiddleName = (String) value.get(FIELD_TO_MIDDLE_NAME);
		toLastName = (String) value.get(FIELD_TO_LAST_NAME);
		tofirstNameLocal = (String) value.get(FIELD_TOFIRST_NAME_LOCAL);
		toLastNameLocal = (String) value.get(FIELD_TO_LAST_NAME_LOCAL);
		toPersonalTitle = (String) value.get(FIELD_TO_PERSONAL_TITLE);
		toSuffix = (String) value.get(FIELD_TO_SUFFIX);
		toGroupName = (String) value.get(FIELD_TO_GROUP_NAME);
		toGroupNameLocal = (String) value.get(FIELD_TO_GROUP_NAME_LOCAL);
		fromFirstName = (String) value.get(FIELD_FROM_FIRST_NAME);
		fromMiddleName = (String) value.get(FIELD_FROM_MIDDLE_NAME);
		fromLastName = (String) value.get(FIELD_FROM_LAST_NAME);
		fromfirstNameLocal = (String) value.get(FIELD_FROMFIRST_NAME_LOCAL);
		fromLastNameLocal = (String) value.get(FIELD_FROM_LAST_NAME_LOCAL);
		fromPersonalTitle = (String) value.get(FIELD_FROM_PERSONAL_TITLE);
		fromSuffix = (String) value.get(FIELD_FROM_SUFFIX);
		fromGroupName = (String) value.get(FIELD_FROM_GROUP_NAME);
		fromGroupNameLocal = (String) value.get(FIELD_FROM_GROUP_NAME_LOCAL);
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

	public static PartyRelationshipAndPartyDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRelationshipAndPartyDetail(value);
	}

	public static List<PartyRelationshipAndPartyDetail> fromValues(
			List<GenericValue> values) {
		List<PartyRelationshipAndPartyDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRelationshipAndPartyDetail(value));
		}
		return entities;
	}
}