package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Content
 */
public class ProductPromoContent implements Serializable {

	public static final long serialVersionUID = 6745593933436687360L;
	public static final String NAME = "ProductPromoContent";
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Product Promo Content Type Id
	 */
	@Getter
	@Setter
	private String productPromoContentTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
		productPromoId, contentId, productPromoContentTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromoContent(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		contentId = (String) value.get(Fields.contentId.name());
		productPromoContentTypeId = (String) value
				.get(Fields.productPromoContentTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductPromoContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoContent(value);
	}

	public static List<ProductPromoContent> fromValues(List<GenericValue> values) {
		List<ProductPromoContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoContent(value));
		}
		return entities;
	}
}