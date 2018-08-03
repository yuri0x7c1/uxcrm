package org.apache.ofbiz.product.product;

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
public class ProductVirtualAndVariantInfo implements Serializable {

	public static final long serialVersionUID = 6767223255394092032L;
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

	public enum Fields {
		productId, productName, internalName, productAssocTypeId, fromDate, thruDate, variantProductId, productFeatureApplTypeId, variantFeatureApplFromDate, variantFeatureApplThruDate, productFeatureId, productFeatureTypeId, productFeatureCategoryId, description, variantPriceTypeId, variantCurrencyUomId, variantProductStoreGroupId, variantPriceFromDate, variantPriceThruDate, variantPrice
	}

	public ProductVirtualAndVariantInfo(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productName = (String) value.get(Fields.productName.name());
		internalName = (String) value.get(Fields.internalName.name());
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		variantProductId = (String) value.get(Fields.variantProductId.name());
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		variantFeatureApplFromDate = (Timestamp) value
				.get(Fields.variantFeatureApplFromDate.name());
		variantFeatureApplThruDate = (Timestamp) value
				.get(Fields.variantFeatureApplThruDate.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productFeatureTypeId = (String) value.get(Fields.productFeatureTypeId
				.name());
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		description = (String) value.get(Fields.description.name());
		variantPriceTypeId = (String) value.get(Fields.variantPriceTypeId
				.name());
		variantCurrencyUomId = (String) value.get(Fields.variantCurrencyUomId
				.name());
		variantProductStoreGroupId = (String) value
				.get(Fields.variantProductStoreGroupId.name());
		variantPriceFromDate = (Timestamp) value
				.get(Fields.variantPriceFromDate.name());
		variantPriceThruDate = (Timestamp) value
				.get(Fields.variantPriceThruDate.name());
		variantPrice = (BigDecimal) value.get(Fields.variantPrice.name());
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