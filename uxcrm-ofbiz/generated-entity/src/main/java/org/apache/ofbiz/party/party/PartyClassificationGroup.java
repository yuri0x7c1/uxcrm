package org.apache.ofbiz.party.party;

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
public class PartyClassificationGroup implements Serializable {

	public static final long serialVersionUID = 1680649357378625536L;
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

	public enum Fields {
		partyClassificationGroupId, partyClassificationTypeId, parentGroupId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyClassificationGroup(GenericValue value) {
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
		partyClassificationTypeId = (String) value
				.get(Fields.partyClassificationTypeId.name());
		parentGroupId = (String) value.get(Fields.parentGroupId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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