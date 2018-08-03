package org.apache.ofbiz.party.party;

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
public class PartyContent implements Serializable {

	public static final long serialVersionUID = 818559827376463872L;
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

	public enum Fields {
		partyId, contentId, partyContentTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyContent(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		contentId = (String) value.get(Fields.contentId.name());
		partyContentTypeId = (String) value.get(Fields.partyContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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