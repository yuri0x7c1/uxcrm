package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Order
 */
public class CommunicationEventOrder implements Serializable {

	public static final long serialVersionUID = 3137843731598005248L;
	public static final String NAME = "CommunicationEventOrder";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
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
		orderId, communicationEventId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CommunicationEventOrder(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CommunicationEventOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventOrder(value);
	}

	public static List<CommunicationEventOrder> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventOrder(value));
		}
		return entities;
	}
}