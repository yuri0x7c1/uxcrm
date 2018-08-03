package org.apache.ofbiz.party.party;

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
public class PartyRelationshipToFrom implements Serializable {

	public static final long serialVersionUID = 6253767299659496448L;
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

	public enum Fields {
		oneRoleTypeIdTo, onePartyIdFrom, onePositionTitle, oneComments, onePriorityTypeId, onePermissionsEnumId, oneRoleTypeIdFrom, oneThruDate, oneFromDate, oneRelationshipName, oneSecurityGroupId, onePartyRelationshipTypeId, oneStatusId, onePartyIdTo, twoRoleTypeIdTo, twoPartyIdFrom, twoPositionTitle, twoComments, twoPriorityTypeId, twoPermissionsEnumId, twoRoleTypeIdFrom, twoThruDate, twoFromDate, twoRelationshipName, twoSecurityGroupId, twoPartyRelationshipTypeId, twoStatusId, twoPartyIdTo
	}

	public PartyRelationshipToFrom(GenericValue value) {
		oneRoleTypeIdTo = (String) value.get(Fields.oneRoleTypeIdTo.name());
		onePartyIdFrom = (String) value.get(Fields.onePartyIdFrom.name());
		onePositionTitle = (String) value.get(Fields.onePositionTitle.name());
		oneComments = (String) value.get(Fields.oneComments.name());
		onePriorityTypeId = (String) value.get(Fields.onePriorityTypeId.name());
		onePermissionsEnumId = (String) value.get(Fields.onePermissionsEnumId
				.name());
		oneRoleTypeIdFrom = (String) value.get(Fields.oneRoleTypeIdFrom.name());
		oneThruDate = (Timestamp) value.get(Fields.oneThruDate.name());
		oneFromDate = (Timestamp) value.get(Fields.oneFromDate.name());
		oneRelationshipName = (String) value.get(Fields.oneRelationshipName
				.name());
		oneSecurityGroupId = (String) value.get(Fields.oneSecurityGroupId
				.name());
		onePartyRelationshipTypeId = (String) value
				.get(Fields.onePartyRelationshipTypeId.name());
		oneStatusId = (String) value.get(Fields.oneStatusId.name());
		onePartyIdTo = (String) value.get(Fields.onePartyIdTo.name());
		twoRoleTypeIdTo = (String) value.get(Fields.twoRoleTypeIdTo.name());
		twoPartyIdFrom = (String) value.get(Fields.twoPartyIdFrom.name());
		twoPositionTitle = (String) value.get(Fields.twoPositionTitle.name());
		twoComments = (String) value.get(Fields.twoComments.name());
		twoPriorityTypeId = (String) value.get(Fields.twoPriorityTypeId.name());
		twoPermissionsEnumId = (String) value.get(Fields.twoPermissionsEnumId
				.name());
		twoRoleTypeIdFrom = (String) value.get(Fields.twoRoleTypeIdFrom.name());
		twoThruDate = (Timestamp) value.get(Fields.twoThruDate.name());
		twoFromDate = (Timestamp) value.get(Fields.twoFromDate.name());
		twoRelationshipName = (String) value.get(Fields.twoRelationshipName
				.name());
		twoSecurityGroupId = (String) value.get(Fields.twoSecurityGroupId
				.name());
		twoPartyRelationshipTypeId = (String) value
				.get(Fields.twoPartyRelationshipTypeId.name());
		twoStatusId = (String) value.get(Fields.twoStatusId.name());
		twoPartyIdTo = (String) value.get(Fields.twoPartyIdTo.name());
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