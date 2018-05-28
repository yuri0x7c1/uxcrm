package org.apache.ofbiz.party.communication;

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
public class CommunicationEventPurpose implements Serializable {

	public static final long serialVersionUID = 1697641794564322304L;
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

	public enum Fields {
		communicationEventPrpTypId, communicationEventId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommunicationEventPurpose(GenericValue value) {
		communicationEventPrpTypId = (String) value
				.get(Fields.communicationEventPrpTypId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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