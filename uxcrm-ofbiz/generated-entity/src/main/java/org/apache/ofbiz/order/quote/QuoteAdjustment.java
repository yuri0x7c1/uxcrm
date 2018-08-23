package org.apache.ofbiz.order.quote;

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
 * Quote Adjustment
 */
@FieldNameConstants
public class QuoteAdjustment implements Serializable {

	public static final long serialVersionUID = 912569028146055168L;
	public static final String NAME = "QuoteAdjustment";
	/**
	 * Quote Adjustment Id
	 */
	@Getter
	@Setter
	private String quoteAdjustmentId;
	/**
	 * Quote Adjustment Type Id
	 */
	@Getter
	@Setter
	private String quoteAdjustmentTypeId;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Quote Item Seq Id
	 */
	@Getter
	@Setter
	private String quoteItemSeqId;
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

	public QuoteAdjustment(GenericValue value) {
		quoteAdjustmentId = (String) value.get(FIELD_QUOTE_ADJUSTMENT_ID);
		quoteAdjustmentTypeId = (String) value
				.get(FIELD_QUOTE_ADJUSTMENT_TYPE_ID);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		description = (String) value.get(FIELD_DESCRIPTION);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		productPromoActionSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_ACTION_SEQ_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		correspondingProductId = (String) value
				.get(FIELD_CORRESPONDING_PRODUCT_ID);
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

	public static QuoteAdjustment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteAdjustment(value);
	}

	public static List<QuoteAdjustment> fromValues(List<GenericValue> values) {
		List<QuoteAdjustment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteAdjustment(value));
		}
		return entities;
	}
}