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
 * Party Relationship To From
 */
@FieldNameConstants
public class PartyRelationshipToFrom implements Serializable {

	public static final long serialVersionUID = 2857218893327007744L;
	public static final String NAME = "PartyRelationshipToFrom";
	/**
	 * One Role Type Id To
	 */
	@Getter
	@Setter
	private String oneRoleTypeIdTo;
	/**
	 * One Party Id From
	 */
	@Getter
	@Setter
	private String onePartyIdFrom;
	/**
	 * One Position Title
	 */
	@Getter
	@Setter
	private String onePositionTitle;
	/**
	 * One Comments
	 */
	@Getter
	@Setter
	private String oneComments;
	/**
	 * One Priority Type Id
	 */
	@Getter
	@Setter
	private String onePriorityTypeId;
	/**
	 * One Permissions Enum Id
	 */
	@Getter
	@Setter
	private String onePermissionsEnumId;
	/**
	 * One Role Type Id From
	 */
	@Getter
	@Setter
	private String oneRoleTypeIdFrom;
	/**
	 * One Thru Date
	 */
	@Getter
	@Setter
	private Timestamp oneThruDate;
	/**
	 * One From Date
	 */
	@Getter
	@Setter
	private Timestamp oneFromDate;
	/**
	 * One Relationship Name
	 */
	@Getter
	@Setter
	private String oneRelationshipName;
	/**
	 * One Security Group Id
	 */
	@Getter
	@Setter
	private String oneSecurityGroupId;
	/**
	 * One Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String onePartyRelationshipTypeId;
	/**
	 * One Status Id
	 */
	@Getter
	@Setter
	private String oneStatusId;
	/**
	 * One Party Id To
	 */
	@Getter
	@Setter
	private String onePartyIdTo;
	/**
	 * Two Role Type Id To
	 */
	@Getter
	@Setter
	private String twoRoleTypeIdTo;
	/**
	 * Two Party Id From
	 */
	@Getter
	@Setter
	private String twoPartyIdFrom;
	/**
	 * Two Position Title
	 */
	@Getter
	@Setter
	private String twoPositionTitle;
	/**
	 * Two Comments
	 */
	@Getter
	@Setter
	private String twoComments;
	/**
	 * Two Priority Type Id
	 */
	@Getter
	@Setter
	private String twoPriorityTypeId;
	/**
	 * Two Permissions Enum Id
	 */
	@Getter
	@Setter
	private String twoPermissionsEnumId;
	/**
	 * Two Role Type Id From
	 */
	@Getter
	@Setter
	private String twoRoleTypeIdFrom;
	/**
	 * Two Thru Date
	 */
	@Getter
	@Setter
	private Timestamp twoThruDate;
	/**
	 * Two From Date
	 */
	@Getter
	@Setter
	private Timestamp twoFromDate;
	/**
	 * Two Relationship Name
	 */
	@Getter
	@Setter
	private String twoRelationshipName;
	/**
	 * Two Security Group Id
	 */
	@Getter
	@Setter
	private String twoSecurityGroupId;
	/**
	 * Two Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String twoPartyRelationshipTypeId;
	/**
	 * Two Status Id
	 */
	@Getter
	@Setter
	private String twoStatusId;
	/**
	 * Two Party Id To
	 */
	@Getter
	@Setter
	private String twoPartyIdTo;

	public PartyRelationshipToFrom(GenericValue value) {
		oneRoleTypeIdTo = (String) value.get(FIELD_ONE_ROLE_TYPE_ID_TO);
		onePartyIdFrom = (String) value.get(FIELD_ONE_PARTY_ID_FROM);
		onePositionTitle = (String) value.get(FIELD_ONE_POSITION_TITLE);
		oneComments = (String) value.get(FIELD_ONE_COMMENTS);
		onePriorityTypeId = (String) value.get(FIELD_ONE_PRIORITY_TYPE_ID);
		onePermissionsEnumId = (String) value
				.get(FIELD_ONE_PERMISSIONS_ENUM_ID);
		oneRoleTypeIdFrom = (String) value.get(FIELD_ONE_ROLE_TYPE_ID_FROM);
		oneThruDate = (Timestamp) value.get(FIELD_ONE_THRU_DATE);
		oneFromDate = (Timestamp) value.get(FIELD_ONE_FROM_DATE);
		oneRelationshipName = (String) value.get(FIELD_ONE_RELATIONSHIP_NAME);
		oneSecurityGroupId = (String) value.get(FIELD_ONE_SECURITY_GROUP_ID);
		onePartyRelationshipTypeId = (String) value
				.get(FIELD_ONE_PARTY_RELATIONSHIP_TYPE_ID);
		oneStatusId = (String) value.get(FIELD_ONE_STATUS_ID);
		onePartyIdTo = (String) value.get(FIELD_ONE_PARTY_ID_TO);
		twoRoleTypeIdTo = (String) value.get(FIELD_TWO_ROLE_TYPE_ID_TO);
		twoPartyIdFrom = (String) value.get(FIELD_TWO_PARTY_ID_FROM);
		twoPositionTitle = (String) value.get(FIELD_TWO_POSITION_TITLE);
		twoComments = (String) value.get(FIELD_TWO_COMMENTS);
		twoPriorityTypeId = (String) value.get(FIELD_TWO_PRIORITY_TYPE_ID);
		twoPermissionsEnumId = (String) value
				.get(FIELD_TWO_PERMISSIONS_ENUM_ID);
		twoRoleTypeIdFrom = (String) value.get(FIELD_TWO_ROLE_TYPE_ID_FROM);
		twoThruDate = (Timestamp) value.get(FIELD_TWO_THRU_DATE);
		twoFromDate = (Timestamp) value.get(FIELD_TWO_FROM_DATE);
		twoRelationshipName = (String) value.get(FIELD_TWO_RELATIONSHIP_NAME);
		twoSecurityGroupId = (String) value.get(FIELD_TWO_SECURITY_GROUP_ID);
		twoPartyRelationshipTypeId = (String) value
				.get(FIELD_TWO_PARTY_RELATIONSHIP_TYPE_ID);
		twoStatusId = (String) value.get(FIELD_TWO_STATUS_ID);
		twoPartyIdTo = (String) value.get(FIELD_TWO_PARTY_ID_TO);
	}

	public static PartyRelationshipToFrom fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRelationshipToFrom(value);
	}

	public static List<PartyRelationshipToFrom> fromValues(
			List<GenericValue> values) {
		List<PartyRelationshipToFrom> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRelationshipToFrom(value));
		}
		return entities;
	}
}