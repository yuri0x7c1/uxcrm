package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Classification
 */
public class PartyClassification implements Serializable {

	public static final long serialVersionUID = 8571343505457177600L;
	public static final String NAME = "PartyClassification";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Classification Group Id
	 */
	@Getter
	@Setter
	private String partyClassificationGroupId;
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
		partyId, partyClassificationGroupId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyClassification(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyClassification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassification(value);
	}

	public static List<PartyClassification> fromValues(List<GenericValue> values) {
		List<PartyClassification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassification(value));
		}
		return entities;
	}
}