package org.apache.ofbiz.party.party;

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
public class PartyRelationshipAndPartyDetail implements Serializable {

	public static final long serialVersionUID = 5062705018390557696L;
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

	public enum Fields {
		relParentTypeId, partyId, partyTypeId, description, partyStatusId, toFirstName, toMiddleName, toLastName, tofirstNameLocal, toLastNameLocal, toPersonalTitle, toSuffix, toGroupName, toGroupNameLocal, fromFirstName, fromMiddleName, fromLastName, fromfirstNameLocal, fromLastNameLocal, fromPersonalTitle, fromSuffix, fromGroupName, fromGroupNameLocal, roleTypeIdTo, partyIdFrom, positionTitle, comments, priorityTypeId, permissionsEnumId, roleTypeIdFrom, thruDate, fromDate, relationshipName, securityGroupId, partyRelationshipTypeId, statusId, partyIdTo
	}

	public PartyRelationshipAndPartyDetail(GenericValue value) {
		relParentTypeId = (String) value.get(Fields.relParentTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		description = (String) value.get(Fields.description.name());
		partyStatusId = (String) value.get(Fields.partyStatusId.name());
		toFirstName = (String) value.get(Fields.toFirstName.name());
		toMiddleName = (String) value.get(Fields.toMiddleName.name());
		toLastName = (String) value.get(Fields.toLastName.name());
		tofirstNameLocal = (String) value.get(Fields.tofirstNameLocal.name());
		toLastNameLocal = (String) value.get(Fields.toLastNameLocal.name());
		toPersonalTitle = (String) value.get(Fields.toPersonalTitle.name());
		toSuffix = (String) value.get(Fields.toSuffix.name());
		toGroupName = (String) value.get(Fields.toGroupName.name());
		toGroupNameLocal = (String) value.get(Fields.toGroupNameLocal.name());
		fromFirstName = (String) value.get(Fields.fromFirstName.name());
		fromMiddleName = (String) value.get(Fields.fromMiddleName.name());
		fromLastName = (String) value.get(Fields.fromLastName.name());
		fromfirstNameLocal = (String) value.get(Fields.fromfirstNameLocal
				.name());
		fromLastNameLocal = (String) value.get(Fields.fromLastNameLocal.name());
		fromPersonalTitle = (String) value.get(Fields.fromPersonalTitle.name());
		fromSuffix = (String) value.get(Fields.fromSuffix.name());
		fromGroupName = (String) value.get(Fields.fromGroupName.name());
		fromGroupNameLocal = (String) value.get(Fields.fromGroupNameLocal
				.name());
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