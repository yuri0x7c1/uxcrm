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
 * Party Content Type
 */
@FieldNameConstants
public class PartyContentType implements Serializable {

	public static final long serialVersionUID = 7203106795257950208L;
	public static final String NAME = "PartyContentType";
	/**
	 * Party Content Type Id
	 */
	@Getter
	@Setter
	private String partyContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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

	public PartyContentType(GenericValue value) {
		partyContentTypeId = (String) value.get(FIELD_PARTY_CONTENT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContentType(value);
	}

	public static List<PartyContentType> fromValues(List<GenericValue> values) {
		List<PartyContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContentType(value));
		}
		return entities;
	}
}