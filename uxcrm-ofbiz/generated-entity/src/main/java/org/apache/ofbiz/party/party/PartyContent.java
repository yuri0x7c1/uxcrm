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
 * Party Content
 */
@FieldNameConstants
public class PartyContent implements Serializable {

	public static final long serialVersionUID = 1730477445909610496L;
	public static final String NAME = "PartyContent";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Party Content Type Id
	 */
	@Getter
	@Setter
	private String partyContentTypeId;
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

	public PartyContent(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		partyContentTypeId = (String) value.get(FIELD_PARTY_CONTENT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContent(value);
	}

	public static List<PartyContent> fromValues(List<GenericValue> values) {
		List<PartyContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContent(value));
		}
		return entities;
	}
}