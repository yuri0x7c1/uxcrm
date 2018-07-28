package org.apache.ofbiz.order.quote;

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
public class QuoteAdjustment implements Serializable {

	public static final long serialVersionUID = 3134095213118278656L;
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

	public enum Fields {
		quoteAdjustmentId, quoteAdjustmentTypeId, quoteId, quoteItemSeqId, comments, description, amount, productPromoId, productPromoRuleId, productPromoActionSeqId, productFeatureId, correspondingProductId, sourceReferenceId, sourcePercentage, customerReferenceId, primaryGeoId, secondaryGeoId, exemptAmount, taxAuthGeoId, taxAuthPartyId, overrideGlAccountId, includeInTax, includeInShipping, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public QuoteAdjustment(GenericValue value) {
		quoteAdjustmentId = (String) value.get(Fields.quoteAdjustmentId.name());
		quoteAdjustmentTypeId = (String) value.get(Fields.quoteAdjustmentTypeId
				.name());
		quoteId = (String) value.get(Fields.quoteId.name());
		quoteItemSeqId = (String) value.get(Fields.quoteItemSeqId.name());
		comments = (String) value.get(Fields.comments.name());
		description = (String) value.get(Fields.description.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		productPromoActionSeqId = (String) value
				.get(Fields.productPromoActionSeqId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		correspondingProductId = (String) value
				.get(Fields.correspondingProductId.name());
		sourceReferenceId = (String) value.get(Fields.sourceReferenceId.name());
		sourcePercentage = (BigDecimal) value.get(Fields.sourcePercentage
				.name());
		customerReferenceId = (String) value.get(Fields.customerReferenceId
				.name());
		primaryGeoId = (String) value.get(Fields.primaryGeoId.name());
		secondaryGeoId = (String) value.get(Fields.secondaryGeoId.name());
		exemptAmount = (BigDecimal) value.get(Fields.exemptAmount.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		includeInTax = (String) value.get(Fields.includeInTax.name());
		includeInShipping = (String) value.get(Fields.includeInShipping.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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