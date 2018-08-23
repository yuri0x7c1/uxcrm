package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class RespondingParty implements Serializable {

	public static final long serialVersionUID = 8349517182784568320L;
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

	public RespondingParty(GenericValue value) {
		respondingPartySeqId = (String) value
				.get(FIELD_RESPONDING_PARTY_SEQ_ID);
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		dateSent = (Timestamp) value.get(FIELD_DATE_SENT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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