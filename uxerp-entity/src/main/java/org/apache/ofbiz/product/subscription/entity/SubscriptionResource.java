package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Resource
 */
public class SubscriptionResource implements Serializable {

	public static final long serialVersionUID = 485418487714030592L;
	public static final String NAME = "SubscriptionResource";
	/**
	 * Subscription Resource Id
	 */
	@Getter
	@Setter
	private String subscriptionResourceId;
	/**
	 * Parent Resource Id
	 */
	@Getter
	@Setter
	private String parentResourceId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Service Name On Expiry
	 */
	@Getter
	@Setter
	private String serviceNameOnExpiry;

	public enum Fields {
		subscriptionResourceId, parentResourceId, description, contentId, webSiteId, serviceNameOnExpiry
	}

	public SubscriptionResource(GenericValue value) {
		subscriptionResourceId = (String) value
				.get(Fields.subscriptionResourceId.name());
		parentResourceId = (String) value.get(Fields.parentResourceId.name());
		description = (String) value.get(Fields.description.name());
		contentId = (String) value.get(Fields.contentId.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		serviceNameOnExpiry = (String) value.get(Fields.serviceNameOnExpiry
				.name());
	}

	public static SubscriptionResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SubscriptionResource(value);
	}

	public static List<SubscriptionResource> fromValues(
			List<GenericValue> values) {
		List<SubscriptionResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SubscriptionResource(value));
		}
		return entities;
	}
}