package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Fulfillment Piece
 */
public class SubscriptionFulfillmentPiece implements Serializable {

	public static final long serialVersionUID = 652268516686622720L;
	public static final String NAME = "SubscriptionFulfillmentPiece";
	/**
	 * Subscription Activity Id
	 */
	@Getter
	@Setter
	private String subscriptionActivityId;
	/**
	 * Subscription Id
	 */
	@Getter
	@Setter
	private String subscriptionId;

	public enum Fields {
		subscriptionActivityId, subscriptionId
	}

	public SubscriptionFulfillmentPiece(GenericValue value) {
		subscriptionActivityId = (String) value
				.get(Fields.subscriptionActivityId.name());
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
	}

	public static SubscriptionFulfillmentPiece fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionFulfillmentPiece(value);
	}

	public static List<SubscriptionFulfillmentPiece> fromValues(
			List<GenericValue> values) {
		List<SubscriptionFulfillmentPiece> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionFulfillmentPiece(value));
		}
		return entities;
	}
}