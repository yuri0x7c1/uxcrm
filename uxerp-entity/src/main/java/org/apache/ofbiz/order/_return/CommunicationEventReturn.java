package org.apache.ofbiz.order._return;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Return
 */
public class CommunicationEventReturn implements Serializable {

	public static final long serialVersionUID = 2339898643439358976L;
	public static final String NAME = "CommunicationEventReturn";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
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
		returnId, communicationEventId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommunicationEventReturn(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CommunicationEventReturn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventReturn(value);
	}

	public static List<CommunicationEventReturn> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventReturn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventReturn(value));
		}
		return entities;
	}
}