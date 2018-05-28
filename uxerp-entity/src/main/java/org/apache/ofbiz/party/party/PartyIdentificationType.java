package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Identification Type
 */
public class PartyIdentificationType implements Serializable {

	public static final long serialVersionUID = 8079586071643551744L;
	public static final String NAME = "PartyIdentificationType";
	/**
	 * Party Identification Type Id
	 */
	@Getter
	@Setter
	private String partyIdentificationTypeId;
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
		partyIdentificationTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyIdentificationType(GenericValue value) {
		partyIdentificationTypeId = (String) value
				.get(Fields.partyIdentificationTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyIdentificationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIdentificationType(value);
	}

	public static List<PartyIdentificationType> fromValues(
			List<GenericValue> values) {
		List<PartyIdentificationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIdentificationType(value));
		}
		return entities;
	}
}