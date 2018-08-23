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
 * Product Promo Code Email
 */
@FieldNameConstants
public class ProductPromoCodeEmail implements Serializable {

	public static final long serialVersionUID = 7778132800007803904L;
	public static final String NAME = "ProductPromoCodeEmail";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Email Address
	 */
	@Getter
	@Setter
	private String emailAddress;
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

	public ProductPromoCodeEmail(GenericValue value) {
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		emailAddress = (String) value.get(FIELD_EMAIL_ADDRESS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoCodeEmail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeEmail(value);
	}

	public static List<ProductPromoCodeEmail> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeEmail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeEmail(value));
		}
		return entities;
	}
}