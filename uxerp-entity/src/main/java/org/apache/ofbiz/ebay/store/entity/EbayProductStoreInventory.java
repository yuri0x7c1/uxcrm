package org.apache.ofbiz.ebay.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Product Store Inventory
 */
public class EbayProductStoreInventory implements Serializable {

	public static final long serialVersionUID = 9156575030714496000L;
	public static final String NAME = "EbayProductStoreInventory";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Folder Id
	 */
	@Getter
	@Setter
	private String folderId;
	/**
	 * Ebay Product Id
	 */
	@Getter
	@Setter
	private Long ebayProductId;
	/**
	 * Quantity Reserved
	 */
	@Getter
	@Setter
	private BigDecimal quantityReserved;
	/**
	 * Available To Promise Listing
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseListing;
	/**
	 * Scheduled
	 */
	@Getter
	@Setter
	private BigDecimal scheduled;
	/**
	 * Active Listing
	 */
	@Getter
	@Setter
	private BigDecimal activeListing;
	/**
	 * Sold
	 */
	@Getter
	@Setter
	private BigDecimal sold;
	/**
	 * Un Sold
	 */
	@Getter
	@Setter
	private BigDecimal unSold;
	/**
	 * Success Ratio
	 */
	@Getter
	@Setter
	private Double successRatio;
	/**
	 * Avg Selling Price
	 */
	@Getter
	@Setter
	private Double avgSellingPrice;
	/**
	 * Reserved Date
	 */
	@Getter
	@Setter
	private Timestamp reservedDate;

	public enum Fields {
		productStoreId, facilityId, productId, folderId, ebayProductId, quantityReserved, availableToPromiseListing, scheduled, activeListing, sold, unSold, successRatio, avgSellingPrice, reservedDate
	}

	public EbayProductStoreInventory(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		productId = (String) value.get(Fields.productId.name());
		folderId = (String) value.get(Fields.folderId.name());
		ebayProductId = (Long) value.get(Fields.ebayProductId.name());
		quantityReserved = (BigDecimal) value.get(Fields.quantityReserved
				.name());
		availableToPromiseListing = (BigDecimal) value
				.get(Fields.availableToPromiseListing.name());
		scheduled = (BigDecimal) value.get(Fields.scheduled.name());
		activeListing = (BigDecimal) value.get(Fields.activeListing.name());
		sold = (BigDecimal) value.get(Fields.sold.name());
		unSold = (BigDecimal) value.get(Fields.unSold.name());
		successRatio = (Double) value.get(Fields.successRatio.name());
		avgSellingPrice = (Double) value.get(Fields.avgSellingPrice.name());
		reservedDate = (Timestamp) value.get(Fields.reservedDate.name());
	}

	public static EbayProductStoreInventory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayProductStoreInventory(value);
	}

	public static List<EbayProductStoreInventory> fromValues(
			List<GenericValue> values) {
		List<EbayProductStoreInventory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayProductStoreInventory(value));
		}
		return entities;
	}
}