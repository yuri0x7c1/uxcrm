package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay User Best Offer
 */
public class EbayUserBestOffer implements Serializable {

	public static final long serialVersionUID = 2840557461198573568L;
	public static final String NAME = "EbayUserBestOffer";
	/**
	 * Item Id
	 */
	@Getter
	@Setter
	private String itemId;
	/**
	 * User Id
	 */
	@Getter
	@Setter
	private String userId;
	/**
	 * Best Offer Id
	 */
	@Getter
	@Setter
	private String bestOfferId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Contact Status
	 */
	@Getter
	@Setter
	private String contactStatus;

	public enum Fields {
		itemId, userId, bestOfferId, productStoreId, contactStatus
	}

	public EbayUserBestOffer(GenericValue value) {
		itemId = (String) value.get(Fields.itemId.name());
		userId = (String) value.get(Fields.userId.name());
		bestOfferId = (String) value.get(Fields.bestOfferId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		contactStatus = (String) value.get(Fields.contactStatus.name());
	}

	public static EbayUserBestOffer fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayUserBestOffer(value);
	}

	public static List<EbayUserBestOffer> fromValues(List<GenericValue> values) {
		List<EbayUserBestOffer> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayUserBestOffer(value));
		}
		return entities;
	}
}