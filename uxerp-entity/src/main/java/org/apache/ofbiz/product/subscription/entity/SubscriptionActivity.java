package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Activity
 */
public class SubscriptionActivity implements Serializable {

	public static final long serialVersionUID = 3537090612647223296L;
	public static final String NAME = "SubscriptionActivity";
	/**
	 * Subscription Activity Id
	 */
	@Getter
	@Setter
	private String subscriptionActivityId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Date Sent
	 */
	@Getter
	@Setter
	private Timestamp dateSent;

	public enum Fields {
		subscriptionActivityId, comments, dateSent
	}

	public SubscriptionActivity(GenericValue value) {
		subscriptionActivityId = (String) value
				.get(Fields.subscriptionActivityId.name());
		comments = (String) value.get(Fields.comments.name());
		dateSent = (Timestamp) value.get(Fields.dateSent.name());
	}

	public static SubscriptionActivity fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionActivity(value);
	}

	public static List<SubscriptionActivity> fromValues(
			List<GenericValue> values) {
		List<SubscriptionActivity> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionActivity(value));
		}
		return entities;
	}
}