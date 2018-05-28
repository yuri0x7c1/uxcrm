package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Identification
 */
public class PartyIdentification implements Serializable {

	public static final long serialVersionUID = 3799218592602243072L;
	public static final String NAME = "PartyIdentification";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Identification Type Id
	 */
	@Getter
	@Setter
	private String partyIdentificationTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;
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
		partyId, partyIdentificationTypeId, idValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyIdentification(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyIdentificationTypeId = (String) value
				.get(Fields.partyIdentificationTypeId.name());
		idValue = (String) value.get(Fields.idValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyIdentification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIdentification(value);
	}

	public static List<PartyIdentification> fromValues(List<GenericValue> values) {
		List<PartyIdentification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIdentification(value));
		}
		return entities;
	}
}