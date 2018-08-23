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
 * Party Classification Type
 */
@FieldNameConstants
public class PartyClassificationType implements Serializable {

	public static final long serialVersionUID = 9038530455884508160L;
	public static final String NAME = "PartyClassificationType";
	/**
	 * Party Classification Type Id
	 */
	@Getter
	@Setter
	private String partyClassificationTypeId;
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

	public PartyClassificationType(GenericValue value) {
		partyClassificationTypeId = (String) value
				.get(FIELD_PARTY_CLASSIFICATION_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyClassificationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassificationType(value);
	}

	public static List<PartyClassificationType> fromValues(
			List<GenericValue> values) {
		List<PartyClassificationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassificationType(value));
		}
		return entities;
	}
}