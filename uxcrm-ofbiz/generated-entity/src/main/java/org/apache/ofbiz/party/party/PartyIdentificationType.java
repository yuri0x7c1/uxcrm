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
 * Party Identification Type
 */
@FieldNameConstants
public class PartyIdentificationType implements Serializable {

	public static final long serialVersionUID = 5446538226192063488L;
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

	public PartyIdentificationType(GenericValue value) {
		partyIdentificationTypeId = (String) value
				.get(FIELD_PARTY_IDENTIFICATION_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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