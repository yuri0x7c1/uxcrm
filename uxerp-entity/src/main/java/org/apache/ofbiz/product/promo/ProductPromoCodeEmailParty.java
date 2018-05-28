package org.apache.ofbiz.product.promo;

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
public class ProductPromoCodeEmailParty implements Serializable {

	public static final long serialVersionUID = 8172439925391184896L;
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

	public enum Fields {
		productPromoCodeId, infoString, partyId, fromDate, thruDate
	}

	public ProductPromoCodeEmailParty(GenericValue value) {
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		infoString = (String) value.get(Fields.infoString.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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