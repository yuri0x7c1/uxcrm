package org.apache.ofbiz.product.subscription;

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
public class SubscriptionCommEvent implements Serializable {

	public static final long serialVersionUID = 3340642057086672896L;
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

	public enum Fields {
		subscriptionId, communicationEventId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SubscriptionCommEvent(GenericValue value) {
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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