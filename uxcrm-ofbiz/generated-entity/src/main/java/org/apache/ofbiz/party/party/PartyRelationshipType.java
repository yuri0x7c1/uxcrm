package org.apache.ofbiz.party.party;

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
public class PartyRelationshipType implements Serializable {

	public static final long serialVersionUID = 193954086758480896L;
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

	public enum Fields {
		partyRelationshipTypeId, parentTypeId, hasTable, partyRelationshipName, description, roleTypeIdValidFrom, roleTypeIdValidTo, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyRelationshipType(GenericValue value) {
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		partyRelationshipName = (String) value.get(Fields.partyRelationshipName
				.name());
		description = (String) value.get(Fields.description.name());
		roleTypeIdValidFrom = (String) value.get(Fields.roleTypeIdValidFrom
				.name());
		roleTypeIdValidTo = (String) value.get(Fields.roleTypeIdValidTo.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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