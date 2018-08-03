package org.apache.ofbiz.product.subscription;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Fulfillment Piece
 */
public class SubscriptionFulfillmentPiece implements Serializable {

	public static final long serialVersionUID = 460697561972167680L;
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
		subscriptionActivityId, subscriptionId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SubscriptionFulfillmentPiece(GenericValue value) {
		subscriptionActivityId = (String) value
				.get(Fields.subscriptionActivityId.name());
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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