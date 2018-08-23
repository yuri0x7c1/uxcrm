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
 * Product Promo Code Party
 */
@FieldNameConstants
public class ProductPromoCodeParty implements Serializable {

	public static final long serialVersionUID = 600458208738944000L;
	public static final String NAME = "ProductPromoCodeParty";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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

	public ProductPromoCodeParty(GenericValue value) {
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoCodeParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeParty(value);
	}

	public static List<ProductPromoCodeParty> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeParty(value));
		}
		return entities;
	}
}