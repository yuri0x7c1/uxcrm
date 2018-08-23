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
 * Product Promo Code
 */
@FieldNameConstants
public class ProductPromoCode implements Serializable {

	public static final long serialVersionUID = 5576198242121738240L;
	public static final String NAME = "ProductPromoCode";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * User Entered
	 */
	@Getter
	@Setter
	private String userEntered;
	/**
	 * Require Email Or Party
	 */
	@Getter
	@Setter
	private String requireEmailOrParty;
	/**
	 * Use Limit Per Code
	 */
	@Getter
	@Setter
	private Long useLimitPerCode;
	/**
	 * Use Limit Per Customer
	 */
	@Getter
	@Setter
	private Long useLimitPerCustomer;
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
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public ProductPromoCode(GenericValue value) {
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		userEntered = (String) value.get(FIELD_USER_ENTERED);
		requireEmailOrParty = (String) value.get(FIELD_REQUIRE_EMAIL_OR_PARTY);
		useLimitPerCode = (Long) value.get(FIELD_USE_LIMIT_PER_CODE);
		useLimitPerCustomer = (Long) value.get(FIELD_USE_LIMIT_PER_CUSTOMER);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCode(value);
	}

	public static List<ProductPromoCode> fromValues(List<GenericValue> values) {
		List<ProductPromoCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCode(value));
		}
		return entities;
	}
}