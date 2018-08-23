package org.apache.ofbiz.product.subscription;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Comm Event
 */
@FieldNameConstants
public class SubscriptionCommEvent implements Serializable {

	public static final long serialVersionUID = 1301658515662014464L;
	public static final String NAME = "SubscriptionCommEvent";
	/**
	 * Subscription Id
	 */
	@Getter
	@Setter
	private String subscriptionId;
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

	public SubscriptionCommEvent(GenericValue value) {
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SubscriptionCommEvent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionCommEvent(value);
	}

	public static List<SubscriptionCommEvent> fromValues(
			List<GenericValue> values) {
		List<SubscriptionCommEvent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionCommEvent(value));
		}
		return entities;
	}
}