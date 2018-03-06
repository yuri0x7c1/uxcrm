package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Type
 */
public class SubscriptionType implements Serializable {

	public static final long serialVersionUID = 5665978561645017088L;
	public static final String NAME = "SubscriptionType";
	/**
	 * Subscription Type Id
	 */
	@Getter
	@Setter
	private String subscriptionTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		subscriptionTypeId, parentTypeId, hasTable, description
	}

	public SubscriptionType(GenericValue value) {
		subscriptionTypeId = (String) value.get(Fields.subscriptionTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SubscriptionType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionType(value);
	}

	public static List<SubscriptionType> fromValues(List<GenericValue> values) {
		List<SubscriptionType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionType(value));
		}
		return entities;
	}
}