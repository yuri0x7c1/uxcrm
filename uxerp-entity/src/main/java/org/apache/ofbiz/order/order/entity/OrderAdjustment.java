package org.apache.ofbiz.order.order.entity;

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
public class OrderAdjustment implements Serializable {

	public static final long serialVersionUID = 4464585527948612608L;
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

	public enum Fields {
		orderAdjustmentId, orderAdjustmentTypeId, orderId, orderItemSeqId, shipGroupSeqId, comments, description, amount, recurringAmount, amountAlreadyIncluded, productPromoId, productPromoRuleId, productPromoActionSeqId, productFeatureId, correspondingProductId, taxAuthorityRateSeqId, sourceReferenceId, sourcePercentage, customerReferenceId, primaryGeoId, secondaryGeoId, exemptAmount, taxAuthGeoId, taxAuthPartyId, overrideGlAccountId, includeInTax, includeInShipping, isManual, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, originalAdjustmentId, oldAmountPerQuantity, oldPercentage
	}

	public OrderAdjustment(GenericValue value) {
		orderAdjustmentId = (String) value.get(Fields.orderAdjustmentId.name());
		orderAdjustmentTypeId = (String) value.get(Fields.orderAdjustmentTypeId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		comments = (String) value.get(Fields.comments.name());
		description = (String) value.get(Fields.description.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		recurringAmount = (BigDecimal) value.get(Fields.recurringAmount.name());
		amountAlreadyIncluded = (BigDecimal) value
				.get(Fields.amountAlreadyIncluded.name());
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
		isManual = (String) value.get(Fields.isManual.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		originalAdjustmentId = (String) value.get(Fields.originalAdjustmentId
				.name());
		oldAmountPerQuantity = (BigDecimal) value
				.get(Fields.oldAmountPerQuantity.name());
		oldPercentage = (Double) value.get(Fields.oldPercentage.name());
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