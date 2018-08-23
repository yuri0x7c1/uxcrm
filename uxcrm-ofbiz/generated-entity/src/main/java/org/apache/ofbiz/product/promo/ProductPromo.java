package org.apache.ofbiz.product.promo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo
 */
@FieldNameConstants
public class ProductPromo implements Serializable {

	public static final long serialVersionUID = 2790396732394919936L;
	public static final String NAME = "ProductPromo";
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Promo Name
	 */
	@Getter
	@Setter
	private String promoName;
	/**
	 * Promo Text
	 */
	@Getter
	@Setter
	private String promoText;
	/**
	 * User Entered
	 */
	@Getter
	@Setter
	private String userEntered;
	/**
	 * Show To Customer
	 */
	@Getter
	@Setter
	private String showToCustomer;
	/**
	 * Require Code
	 */
	@Getter
	@Setter
	private String requireCode;
	/**
	 * Use Limit Per Order
	 */
	@Getter
	@Setter
	private Long useLimitPerOrder;
	/**
	 * Use Limit Per Customer
	 */
	@Getter
	@Setter
	private Long useLimitPerCustomer;
	/**
	 * Use Limit Per Promotion
	 */
	@Getter
	@Setter
	private Long useLimitPerPromotion;
	/**
	 * Billback Factor
	 */
	@Getter
	@Setter
	private BigDecimal billbackFactor;
	/**
	 * Override Org Party Id
	 */
	@Getter
	@Setter
	private String overrideOrgPartyId;
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

	public ProductPromo(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		promoName = (String) value.get(FIELD_PROMO_NAME);
		promoText = (String) value.get(FIELD_PROMO_TEXT);
		userEntered = (String) value.get(FIELD_USER_ENTERED);
		showToCustomer = (String) value.get(FIELD_SHOW_TO_CUSTOMER);
		requireCode = (String) value.get(FIELD_REQUIRE_CODE);
		useLimitPerOrder = (Long) value.get(FIELD_USE_LIMIT_PER_ORDER);
		useLimitPerCustomer = (Long) value.get(FIELD_USE_LIMIT_PER_CUSTOMER);
		useLimitPerPromotion = (Long) value.get(FIELD_USE_LIMIT_PER_PROMOTION);
		billbackFactor = (BigDecimal) value.get(FIELD_BILLBACK_FACTOR);
		overrideOrgPartyId = (String) value.get(FIELD_OVERRIDE_ORG_PARTY_ID);
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

	public static ProductPromo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromo(value);
	}

	public static List<ProductPromo> fromValues(List<GenericValue> values) {
		List<ProductPromo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromo(value));
		}
		return entities;
	}
}