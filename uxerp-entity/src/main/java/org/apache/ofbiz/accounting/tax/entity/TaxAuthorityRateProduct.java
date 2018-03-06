package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Rate Product
 */
public class TaxAuthorityRateProduct implements Serializable {

	public static final long serialVersionUID = 7999470425610145792L;
	public static final String NAME = "TaxAuthorityRateProduct";
	/**
	 * Tax Authority Rate Seq Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateSeqId;
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
	 * Tax Authority Rate Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateTypeId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Title Transfer Enum Id
	 */
	@Getter
	@Setter
	private String titleTransferEnumId;
	/**
	 * Min Item Price
	 */
	@Getter
	@Setter
	private BigDecimal minItemPrice;
	/**
	 * Min Purchase
	 */
	@Getter
	@Setter
	private BigDecimal minPurchase;
	/**
	 * Tax Shipping
	 */
	@Getter
	@Setter
	private String taxShipping;
	/**
	 * Tax Percentage
	 */
	@Getter
	@Setter
	private BigDecimal taxPercentage;
	/**
	 * Tax Promotions
	 */
	@Getter
	@Setter
	private String taxPromotions;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		taxAuthorityRateSeqId, taxAuthGeoId, taxAuthPartyId, taxAuthorityRateTypeId, productStoreId, productCategoryId, titleTransferEnumId, minItemPrice, minPurchase, taxShipping, taxPercentage, taxPromotions, fromDate, thruDate, description
	}

	public TaxAuthorityRateProduct(GenericValue value) {
		taxAuthorityRateSeqId = (String) value.get(Fields.taxAuthorityRateSeqId
				.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		taxAuthorityRateTypeId = (String) value
				.get(Fields.taxAuthorityRateTypeId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		titleTransferEnumId = (String) value.get(Fields.titleTransferEnumId
				.name());
		minItemPrice = (BigDecimal) value.get(Fields.minItemPrice.name());
		minPurchase = (BigDecimal) value.get(Fields.minPurchase.name());
		taxShipping = (String) value.get(Fields.taxShipping.name());
		taxPercentage = (BigDecimal) value.get(Fields.taxPercentage.name());
		taxPromotions = (String) value.get(Fields.taxPromotions.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TaxAuthorityRateProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityRateProduct(value);
	}

	public static List<TaxAuthorityRateProduct> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityRateProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityRateProduct(value));
		}
		return entities;
	}
}