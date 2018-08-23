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
 * Product Promo Code Email Party
 */
@FieldNameConstants
public class ProductPromoCodeEmailParty implements Serializable {

	public static final long serialVersionUID = 1212488661182681088L;
	public static final String NAME = "ProductPromoCodeEmailParty";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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

	public ProductPromoCodeEmailParty(GenericValue value) {
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		infoString = (String) value.get(FIELD_INFO_STRING);
		partyId = (String) value.get(FIELD_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static ProductPromoCodeEmailParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeEmailParty(value);
	}

	public static List<ProductPromoCodeEmailParty> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeEmailParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeEmailParty(value));
		}
		return entities;
	}
}