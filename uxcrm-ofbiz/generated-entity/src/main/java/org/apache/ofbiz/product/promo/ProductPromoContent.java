package org.apache.ofbiz.product.promo;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductPromoContent implements Serializable {

	public static final long serialVersionUID = 2912768878557327360L;
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

	public ProductPromoContent(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		productPromoContentTypeId = (String) value
				.get(FIELD_PRODUCT_PROMO_CONTENT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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