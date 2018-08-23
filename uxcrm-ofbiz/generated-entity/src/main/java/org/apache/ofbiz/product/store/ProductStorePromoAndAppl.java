package org.apache.ofbiz.product.store;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Promo And Appl
 */
@FieldNameConstants
public class ProductStorePromoAndAppl implements Serializable {

	public static final long serialVersionUID = 579919414681731072L;
	public static final String NAME = "ProductStorePromoAndAppl";
	/**
	 * Promo Name
	 */
	@Getter
	@Setter
	private String promoName;
	/**
	 * User Entered
	 */
	@Getter
	@Setter
	private String userEntered;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Manual Only
	 */
	@Getter
	@Setter
	private String manualOnly;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public ProductStorePromoAndAppl(GenericValue value) {
		promoName = (String) value.get(FIELD_PROMO_NAME);
		userEntered = (String) value.get(FIELD_USER_ENTERED);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		manualOnly = (String) value.get(FIELD_MANUAL_ONLY);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static ProductStorePromoAndAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStorePromoAndAppl(value);
	}

	public static List<ProductStorePromoAndAppl> fromValues(
			List<GenericValue> values) {
		List<ProductStorePromoAndAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStorePromoAndAppl(value));
		}
		return entities;
	}
}