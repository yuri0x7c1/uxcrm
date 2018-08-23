package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Virtual And Variant Info
 */
@FieldNameConstants
public class ProductVirtualAndVariantInfo implements Serializable {

	public static final long serialVersionUID = 4554724168005218304L;
	public static final String NAME = "ProductVirtualAndVariantInfo";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Product Assoc Type Id
	 */
	@Getter
	@Setter
	private String productAssocTypeId;
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
	 * Variant Product Id
	 */
	@Getter
	@Setter
	private String variantProductId;
	/**
	 * Product Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String productFeatureApplTypeId;
	/**
	 * Variant Feature Appl From Date
	 */
	@Getter
	@Setter
	private Timestamp variantFeatureApplFromDate;
	/**
	 * Variant Feature Appl Thru Date
	 */
	@Getter
	@Setter
	private Timestamp variantFeatureApplThruDate;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Product Feature Type Id
	 */
	@Getter
	@Setter
	private String productFeatureTypeId;
	/**
	 * Product Feature Category Id
	 */
	@Getter
	@Setter
	private String productFeatureCategoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Variant Price Type Id
	 */
	@Getter
	@Setter
	private String variantPriceTypeId;
	/**
	 * Variant Currency Uom Id
	 */
	@Getter
	@Setter
	private String variantCurrencyUomId;
	/**
	 * Variant Product Store Group Id
	 */
	@Getter
	@Setter
	private String variantProductStoreGroupId;
	/**
	 * Variant Price From Date
	 */
	@Getter
	@Setter
	private Timestamp variantPriceFromDate;
	/**
	 * Variant Price Thru Date
	 */
	@Getter
	@Setter
	private Timestamp variantPriceThruDate;
	/**
	 * Variant Price
	 */
	@Getter
	@Setter
	private BigDecimal variantPrice;

	public ProductVirtualAndVariantInfo(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		productAssocTypeId = (String) value.get(FIELD_PRODUCT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		variantProductId = (String) value.get(FIELD_VARIANT_PRODUCT_ID);
		productFeatureApplTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_APPL_TYPE_ID);
		variantFeatureApplFromDate = (Timestamp) value
				.get(FIELD_VARIANT_FEATURE_APPL_FROM_DATE);
		variantFeatureApplThruDate = (Timestamp) value
				.get(FIELD_VARIANT_FEATURE_APPL_THRU_DATE);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		productFeatureTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_TYPE_ID);
		productFeatureCategoryId = (String) value
				.get(FIELD_PRODUCT_FEATURE_CATEGORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		variantPriceTypeId = (String) value.get(FIELD_VARIANT_PRICE_TYPE_ID);
		variantCurrencyUomId = (String) value
				.get(FIELD_VARIANT_CURRENCY_UOM_ID);
		variantProductStoreGroupId = (String) value
				.get(FIELD_VARIANT_PRODUCT_STORE_GROUP_ID);
		variantPriceFromDate = (Timestamp) value
				.get(FIELD_VARIANT_PRICE_FROM_DATE);
		variantPriceThruDate = (Timestamp) value
				.get(FIELD_VARIANT_PRICE_THRU_DATE);
		variantPrice = (BigDecimal) value.get(FIELD_VARIANT_PRICE);
	}

	public static ProductVirtualAndVariantInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductVirtualAndVariantInfo(value);
	}

	public static List<ProductVirtualAndVariantInfo> fromValues(
			List<GenericValue> values) {
		List<ProductVirtualAndVariantInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductVirtualAndVariantInfo(value));
		}
		return entities;
	}
}