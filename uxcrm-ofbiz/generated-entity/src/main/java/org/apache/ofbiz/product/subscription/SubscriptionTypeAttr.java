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
 * Subscription Type Attr
 */
@FieldNameConstants
public class SubscriptionTypeAttr implements Serializable {

	public static final long serialVersionUID = 8611364037965401088L;
	public static final String NAME = "SubscriptionTypeAttr";
	/**
	 * Subscription Type Id
	 */
	@Getter
	@Setter
	private String subscriptionTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public SubscriptionTypeAttr(GenericValue value) {
		subscriptionTypeId = (String) value.get(FIELD_SUBSCRIPTION_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SubscriptionTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionTypeAttr(value);
	}

	public static List<SubscriptionTypeAttr> fromValues(
			List<GenericValue> values) {
		List<SubscriptionTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionTypeAttr(value));
		}
		return entities;
	}
}