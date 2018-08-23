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
 * Party Classification Group
 */
@FieldNameConstants
public class PartyClassificationGroup implements Serializable {

	public static final long serialVersionUID = 4565103809559781376L;
	public static final String NAME = "PartyClassificationGroup";
	/**
	 * Party Classification Group Id
	 */
	@Getter
	@Setter
	private String partyClassificationGroupId;
	/**
	 * Party Classification Type Id
	 */
	@Getter
	@Setter
	private String partyClassificationTypeId;
	/**
	 * Parent Group Id
	 */
	@Getter
	@Setter
	private String parentGroupId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public PartyClassificationGroup(GenericValue value) {
		partyClassificationGroupId = (String) value
				.get(FIELD_PARTY_CLASSIFICATION_GROUP_ID);
		partyClassificationTypeId = (String) value
				.get(FIELD_PARTY_CLASSIFICATION_TYPE_ID);
		parentGroupId = (String) value.get(FIELD_PARENT_GROUP_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyClassificationGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassificationGroup(value);
	}

	public static List<PartyClassificationGroup> fromValues(
			List<GenericValue> values) {
		List<PartyClassificationGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassificationGroup(value));
		}
		return entities;
	}
}