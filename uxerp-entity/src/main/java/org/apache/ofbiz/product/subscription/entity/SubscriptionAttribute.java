package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Attribute
 */
public class SubscriptionAttribute implements Serializable {

	public static final long serialVersionUID = 3763867666012108800L;
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

	public enum Fields {
		subscriptionId, attrName, attrValue, attrDescription
	}

	public SubscriptionAttribute(GenericValue value) {
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
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