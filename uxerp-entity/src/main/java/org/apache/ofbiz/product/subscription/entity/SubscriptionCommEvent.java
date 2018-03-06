package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Comm Event
 */
public class SubscriptionCommEvent implements Serializable {

	public static final long serialVersionUID = 5137293990632762368L;
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

	public enum Fields {
		subscriptionId, communicationEventId
	}

	public SubscriptionCommEvent(GenericValue value) {
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
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