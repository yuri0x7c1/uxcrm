package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Product Listing
 */
public class EbayProductListing implements Serializable {

	public static final long serialVersionUID = 4066396965127285760L;
	public static final String NAME = "EbayProductListing";
	/**
	 * Product Listing Id
	 */
	@Getter
	@Setter
	private String productListingId;
	/**
	 * Item Id
	 */
	@Getter
	@Setter
	private String itemId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Listing Xml
	 */
	@Getter
	@Setter
	private String listingXml;
	/**
	 * Start Date Time
	 */
	@Getter
	@Setter
	private Timestamp startDateTime;
	/**
	 * End Date Time
	 */
	@Getter
	@Setter
	private Timestamp endDateTime;
	/**
	 * Auto Relisting
	 */
	@Getter
	@Setter
	private String autoRelisting;

	public enum Fields {
		productListingId, itemId, productStoreId, productId, userLoginId, statusId, listingXml, startDateTime, endDateTime, autoRelisting
	}

	public EbayProductListing(GenericValue value) {
		productListingId = (String) value.get(Fields.productListingId.name());
		itemId = (String) value.get(Fields.itemId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productId = (String) value.get(Fields.productId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		statusId = (String) value.get(Fields.statusId.name());
		listingXml = (String) value.get(Fields.listingXml.name());
		startDateTime = (Timestamp) value.get(Fields.startDateTime.name());
		endDateTime = (Timestamp) value.get(Fields.endDateTime.name());
		autoRelisting = (String) value.get(Fields.autoRelisting.name());
	}

	public static EbayProductListing fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayProductListing(value);
	}

	public static List<EbayProductListing> fromValues(List<GenericValue> values) {
		List<EbayProductListing> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayProductListing(value));
		}
		return entities;
	}
}