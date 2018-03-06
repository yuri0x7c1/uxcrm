package org.apache.ofbiz.order._return.entity;

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
public class ReturnAdjustment implements Serializable {

	public static final long serialVersionUID = 4394049388619549696L;
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

	public enum Fields {
		returnAdjustmentId, returnAdjustmentTypeId, returnId, returnItemSeqId, shipGroupSeqId, comments, description, returnTypeId, orderAdjustmentId, amount, productPromoId, productPromoRuleId, productPromoActionSeqId, productFeatureId, correspondingProductId, taxAuthorityRateSeqId, sourceReferenceId, sourcePercentage, customerReferenceId, primaryGeoId, secondaryGeoId, exemptAmount, taxAuthGeoId, taxAuthPartyId, overrideGlAccountId, includeInTax, includeInShipping, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public ReturnAdjustment(GenericValue value) {
		returnAdjustmentId = (String) value.get(Fields.returnAdjustmentId
				.name());
		returnAdjustmentTypeId = (String) value
				.get(Fields.returnAdjustmentTypeId.name());
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		comments = (String) value.get(Fields.comments.name());
		description = (String) value.get(Fields.description.name());
		returnTypeId = (String) value.get(Fields.returnTypeId.name());
		orderAdjustmentId = (String) value.get(Fields.orderAdjustmentId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		productPromoActionSeqId = (String) value
				.get(Fields.productPromoActionSeqId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		correspondingProductId = (String) value
				.get(Fields.correspondingProductId.name());
		taxAuthorityRateSeqId = (String) value.get(Fields.taxAuthorityRateSeqId
				.name());
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