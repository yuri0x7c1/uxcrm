package org.apache.ofbiz.product.subscription;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Attribute
 */
public class SubscriptionAttribute implements Serializable {

	public static final long serialVersionUID = 6616247911867583488L;
	public static final String NAME = "SubscriptionAttribute";
	/**
	 * Subscription Id
	 */
	@Getter
	@Setter
	private String subscriptionId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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
		subscriptionId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SubscriptionAttribute(GenericValue value) {
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SubscriptionAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionAttribute(value);
	}

	public static List<SubscriptionAttribute> fromValues(
			List<GenericValue> values) {
		List<SubscriptionAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionAttribute(value));
		}
		return entities;
	}
}