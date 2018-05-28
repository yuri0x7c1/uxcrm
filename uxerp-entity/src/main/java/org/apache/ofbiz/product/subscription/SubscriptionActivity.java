package org.apache.ofbiz.product.subscription;

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

	public static final long serialVersionUID = 8354792303693173760L;
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
		subscriptionActivityId, comments, dateSent, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SubscriptionActivity(GenericValue value) {
		subscriptionActivityId = (String) value
				.get(Fields.subscriptionActivityId.name());
		comments = (String) value.get(Fields.comments.name());
		dateSent = (Timestamp) value.get(Fields.dateSent.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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