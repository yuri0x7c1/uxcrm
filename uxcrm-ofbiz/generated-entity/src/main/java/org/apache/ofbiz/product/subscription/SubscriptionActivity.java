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
 * Subscription Activity
 */
@FieldNameConstants
public class SubscriptionActivity implements Serializable {

	public static final long serialVersionUID = 5425925746265253888L;
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

	public SubscriptionActivity(GenericValue value) {
		subscriptionActivityId = (String) value
				.get(FIELD_SUBSCRIPTION_ACTIVITY_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		dateSent = (Timestamp) value.get(FIELD_DATE_SENT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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