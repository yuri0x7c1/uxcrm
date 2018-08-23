package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Purpose
 */
@FieldNameConstants
public class CommunicationEventPurpose implements Serializable {

	public static final long serialVersionUID = 6868275025658807296L;
	public static final String NAME = "CommunicationEventPurpose";
	/**
	 * Communication Event Prp Typ Id
	 */
	@Getter
	@Setter
	private String communicationEventPrpTypId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
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

	public CommunicationEventPurpose(GenericValue value) {
		communicationEventPrpTypId = (String) value
				.get(FIELD_COMMUNICATION_EVENT_PRP_TYP_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CommunicationEventPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventPurpose(value);
	}

	public static List<CommunicationEventPurpose> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventPurpose(value));
		}
		return entities;
	}
}