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
 * Subscription Resource
 */
@FieldNameConstants
public class SubscriptionResource implements Serializable {

	public static final long serialVersionUID = 2699097313058270208L;
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

	public SubscriptionResource(GenericValue value) {
		subscriptionResourceId = (String) value
				.get(FIELD_SUBSCRIPTION_RESOURCE_ID);
		parentResourceId = (String) value.get(FIELD_PARENT_RESOURCE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		serviceNameOnExpiry = (String) value.get(FIELD_SERVICE_NAME_ON_EXPIRY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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