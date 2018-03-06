package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Relationship
 */
public class PartyRelationship implements Serializable {

	public static final long serialVersionUID = 7583473255730359296L;
	public static final String NAME = "PartyRelationship";
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Priority Type Id
	 */
	@Getter
	@Setter
	private String priorityTypeId;
	/**
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * Permissions Enum Id
	 */
	@Getter
	@Setter
	private String permissionsEnumId;
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

	public enum Fields {
		partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, fromDate, thruDate, statusId, relationshipName, securityGroupId, priorityTypeId, partyRelationshipTypeId, permissionsEnumId, positionTitle, comments
	}

	public PartyRelationship(GenericValue value) {
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		relationshipName = (String) value.get(Fields.relationshipName.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		priorityTypeId = (String) value.get(Fields.priorityTypeId.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		permissionsEnumId = (String) value.get(Fields.permissionsEnumId.name());
		positionTitle = (String) value.get(Fields.positionTitle.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static PartyRelationship fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRelationship(value);
	}

	public static List<PartyRelationship> fromValues(List<GenericValue> values) {
		List<PartyRelationship> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRelationship(value));
		}
		return entities;
	}
}