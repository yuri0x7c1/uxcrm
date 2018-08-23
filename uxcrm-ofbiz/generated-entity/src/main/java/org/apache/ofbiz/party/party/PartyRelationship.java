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
 * Party Relationship
 */
@FieldNameConstants
public class PartyRelationship implements Serializable {

	public static final long serialVersionUID = 1654703683046719488L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public PartyRelationship(GenericValue value) {
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		relationshipName = (String) value.get(FIELD_RELATIONSHIP_NAME);
		securityGroupId = (String) value.get(FIELD_SECURITY_GROUP_ID);
		priorityTypeId = (String) value.get(FIELD_PRIORITY_TYPE_ID);
		partyRelationshipTypeId = (String) value
				.get(FIELD_PARTY_RELATIONSHIP_TYPE_ID);
		permissionsEnumId = (String) value.get(FIELD_PERMISSIONS_ENUM_ID);
		positionTitle = (String) value.get(FIELD_POSITION_TITLE);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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