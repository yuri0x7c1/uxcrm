package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Responding Party
 */
public class RespondingParty implements Serializable {

	public static final long serialVersionUID = 3110289625825953792L;
	public static final String NAME = "RespondingParty";
	/**
	 * Responding Party Seq Id
	 */
	@Getter
	@Setter
	private String respondingPartySeqId;
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Date Sent
	 */
	@Getter
	@Setter
	private Timestamp dateSent;

	public enum Fields {
		respondingPartySeqId, custRequestId, partyId, contactMechId, dateSent
	}

	public RespondingParty(GenericValue value) {
		respondingPartySeqId = (String) value.get(Fields.respondingPartySeqId
				.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		partyId = (String) value.get(Fields.partyId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		dateSent = (Timestamp) value.get(Fields.dateSent.name());
	}

	public static RespondingParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RespondingParty(value);
	}

	public static List<RespondingParty> fromValues(List<GenericValue> values) {
		List<RespondingParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RespondingParty(value));
		}
		return entities;
	}
}