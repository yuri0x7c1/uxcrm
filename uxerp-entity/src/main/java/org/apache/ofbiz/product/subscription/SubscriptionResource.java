package org.apache.ofbiz.product.subscription;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription Resource
 */
public class SubscriptionResource implements Serializable {

	public static final long serialVersionUID = 5461747711204346880L;
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
		subscriptionResourceId, parentResourceId, description, contentId, webSiteId, serviceNameOnExpiry, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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