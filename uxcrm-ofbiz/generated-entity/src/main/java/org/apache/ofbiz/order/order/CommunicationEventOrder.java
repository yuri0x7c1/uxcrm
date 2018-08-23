package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CommunicationEventOrder implements Serializable {

	public static final long serialVersionUID = 446909750170511360L;
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

	public CommunicationEventOrder(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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