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
 * Subscription Fulfillment Piece
 */
@FieldNameConstants
public class SubscriptionFulfillmentPiece implements Serializable {

	public static final long serialVersionUID = 2302847133222247424L;
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

	public SubscriptionFulfillmentPiece(GenericValue value) {
		subscriptionActivityId = (String) value
				.get(FIELD_SUBSCRIPTION_ACTIVITY_ID);
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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