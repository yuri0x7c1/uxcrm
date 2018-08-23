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
 * Party Relationship Type
 */
@FieldNameConstants
public class PartyRelationshipType implements Serializable {

	public static final long serialVersionUID = 6421503131844329472L;
	public static final String NAME = "PartyRelationshipType";
	/**
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Party Relationship Name
	 */
	@Getter
	@Setter
	private String partyRelationshipName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Role Type Id Valid From
	 */
	@Getter
	@Setter
	private String roleTypeIdValidFrom;
	/**
	 * Role Type Id Valid To
	 */
	@Getter
	@Setter
	private String roleTypeIdValidTo;
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

	public PartyRelationshipType(GenericValue value) {
		partyRelationshipTypeId = (String) value
				.get(FIELD_PARTY_RELATIONSHIP_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		partyRelationshipName = (String) value
				.get(FIELD_PARTY_RELATIONSHIP_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		roleTypeIdValidFrom = (String) value.get(FIELD_ROLE_TYPE_ID_VALID_FROM);
		roleTypeIdValidTo = (String) value.get(FIELD_ROLE_TYPE_ID_VALID_TO);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyRelationshipType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRelationshipType(value);
	}

	public static List<PartyRelationshipType> fromValues(
			List<GenericValue> values) {
		List<PartyRelationshipType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRelationshipType(value));
		}
		return entities;
	}
}