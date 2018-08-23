package org.apache.ofbiz.order._return;

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
 * Return Adjustment
 */
@FieldNameConstants
public class ReturnAdjustment implements Serializable {

	public static final long serialVersionUID = 4289745716464107520L;
	public static final String NAME = "ReturnAdjustment";
	/**
	 * Return Adjustment Id
	 */
	@Getter
	@Setter
	private String returnAdjustmentId;
	/**
	 * Return Adjustment Type Id
	 */
	@Getter
	@Setter
	private String returnAdjustmentTypeId;
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
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
	 * Return Type Id
	 */
	@Getter
	@Setter
	private String returnTypeId;
	/**
	 * Order Adjustment Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
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

	public ReturnAdjustment(GenericValue value) {
		returnAdjustmentId = (String) value.get(FIELD_RETURN_ADJUSTMENT_ID);
		returnAdjustmentTypeId = (String) value
				.get(FIELD_RETURN_ADJUSTMENT_TYPE_ID);
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		description = (String) value.get(FIELD_DESCRIPTION);
		returnTypeId = (String) value.get(FIELD_RETURN_TYPE_ID);
		orderAdjustmentId = (String) value.get(FIELD_ORDER_ADJUSTMENT_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
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

	public static ReturnAdjustment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnAdjustment(value);
	}

	public static List<ReturnAdjustment> fromValues(List<GenericValue> values) {
		List<ReturnAdjustment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnAdjustment(value));
		}
		return entities;
	}
}