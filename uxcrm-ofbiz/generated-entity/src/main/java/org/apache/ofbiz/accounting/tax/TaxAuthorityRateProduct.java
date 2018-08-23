package org.apache.ofbiz.accounting.tax;

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
 * Tax Authority Rate Product
 */
@FieldNameConstants
public class TaxAuthorityRateProduct implements Serializable {

	public static final long serialVersionUID = 8689111536454505472L;
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
	/**
	 * Is Tax In Shipping Price
	 */
	@Getter
	@Setter
	private String isTaxInShippingPrice;

	public TaxAuthorityRateProduct(GenericValue value) {
		taxAuthorityRateSeqId = (String) value
				.get(FIELD_TAX_AUTHORITY_RATE_SEQ_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		taxAuthorityRateTypeId = (String) value
				.get(FIELD_TAX_AUTHORITY_RATE_TYPE_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		titleTransferEnumId = (String) value.get(FIELD_TITLE_TRANSFER_ENUM_ID);
		minItemPrice = (BigDecimal) value.get(FIELD_MIN_ITEM_PRICE);
		minPurchase = (BigDecimal) value.get(FIELD_MIN_PURCHASE);
		taxShipping = (String) value.get(FIELD_TAX_SHIPPING);
		taxPercentage = (BigDecimal) value.get(FIELD_TAX_PERCENTAGE);
		taxPromotions = (String) value.get(FIELD_TAX_PROMOTIONS);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		isTaxInShippingPrice = (String) value
				.get(FIELD_IS_TAX_IN_SHIPPING_PRICE);
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