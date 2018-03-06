package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Type Attr
 */
public class SubscriptionTypeAttr implements Serializable {

	public static final long serialVersionUID = 4910021710604776448L;
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

	public enum Fields {
		subscriptionTypeId, attrName, description
	}

	public SubscriptionTypeAttr(GenericValue value) {
		subscriptionTypeId = (String) value.get(Fields.subscriptionTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
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