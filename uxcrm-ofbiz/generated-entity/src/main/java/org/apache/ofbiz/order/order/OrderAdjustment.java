package org.apache.ofbiz.order.order;

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
 * Order Adjustment
 */
@FieldNameConstants
public class OrderAdjustment implements Serializable {

	public static final long serialVersionUID = 6385105323894967296L;
	public static final String NAME = "OrderAdjustment";
	/**
	 * Order Adjustment Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentId;
	/**
	 * Order Adjustment Type Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentTypeId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Recurring Amount
	 */
	@Getter
	@Setter
	private BigDecimal recurringAmount;
	/**
	 * Amount Already Included
	 */
	@Getter
	@Setter
	private BigDecimal amountAlreadyIncluded;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Product Promo Rule Id
	 */
	@Getter
	@Setter
	private String productPromoRuleId;
	/**
	 * Product Promo Action Seq Id
	 */
	@Getter
	@Setter
	private String productPromoActionSeqId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Corresponding Product Id
	 */
	@Getter
	@Setter
	private String correspondingProductId;
	/**
	 * Tax Authority Rate Seq Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateSeqId;
	/**
	 * Source Reference Id
	 */
	@Getter
	@Setter
	private String sourceReferenceId;
	/**
	 * Source Percentage
	 */
	@Getter
	@Setter
	private BigDecimal sourcePercentage;
	/**
	 * Customer Reference Id
	 */
	@Getter
	@Setter
	private String customerReferenceId;
	/**
	 * Primary Geo Id
	 */
	@Getter
	@Setter
	private String primaryGeoId;
	/**
	 * Secondary Geo Id
	 */
	@Getter
	@Setter
	private String secondaryGeoId;
	/**
	 * Exempt Amount
	 */
	@Getter
	@Setter
	private BigDecimal exemptAmount;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Include In Tax
	 */
	@Getter
	@Setter
	private String includeInTax;
	/**
	 * Include In Shipping
	 */
	@Getter
	@Setter
	private String includeInShipping;
	/**
	 * Is Manual
	 */
	@Getter
	@Setter
	private String isManual;
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
	 * Original Adjustment Id
	 */
	@Getter
	@Setter
	private String originalAdjustmentId;
	/**
	 * Old Amount Per Quantity
	 */
	@Getter
	@Setter
	private BigDecimal oldAmountPerQuantity;
	/**
	 * Old Percentage
	 */
	@Getter
	@Setter
	private Double oldPercentage;
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

	public OrderAdjustment(GenericValue value) {
		orderAdjustmentId = (String) value.get(FIELD_ORDER_ADJUSTMENT_ID);
		orderAdjustmentTypeId = (String) value
				.get(FIELD_ORDER_ADJUSTMENT_TYPE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		description = (String) value.get(FIELD_DESCRIPTION);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		recurringAmount = (BigDecimal) value.get(FIELD_RECURRING_AMOUNT);
		amountAlreadyIncluded = (BigDecimal) value
				.get(FIELD_AMOUNT_ALREADY_INCLUDED);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		productPromoActionSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_ACTION_SEQ_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		correspondingProductId = (String) value
				.get(FIELD_CORRESPONDING_PRODUCT_ID);
		taxAuthorityRateSeqId = (String) value
				.get(FIELD_TAX_AUTHORITY_RATE_SEQ_ID);
		sourceReferenceId = (String) value.get(FIELD_SOURCE_REFERENCE_ID);
		sourcePercentage = (BigDecimal) value.get(FIELD_SOURCE_PERCENTAGE);
		customerReferenceId = (String) value.get(FIELD_CUSTOMER_REFERENCE_ID);
		primaryGeoId = (String) value.get(FIELD_PRIMARY_GEO_ID);
		secondaryGeoId = (String) value.get(FIELD_SECONDARY_GEO_ID);
		exemptAmount = (BigDecimal) value.get(FIELD_EXEMPT_AMOUNT);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		includeInTax = (String) value.get(FIELD_INCLUDE_IN_TAX);
		includeInShipping = (String) value.get(FIELD_INCLUDE_IN_SHIPPING);
		isManual = (String) value.get(FIELD_IS_MANUAL);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		originalAdjustmentId = (String) value.get(FIELD_ORIGINAL_ADJUSTMENT_ID);
		oldAmountPerQuantity = (BigDecimal) value
				.get(FIELD_OLD_AMOUNT_PER_QUANTITY);
		oldPercentage = (Double) value.get(FIELD_OLD_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderAdjustment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAdjustment(value);
	}

	public static List<OrderAdjustment> fromValues(List<GenericValue> values) {
		List<OrderAdjustment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAdjustment(value));
		}
		return entities;
	}
}