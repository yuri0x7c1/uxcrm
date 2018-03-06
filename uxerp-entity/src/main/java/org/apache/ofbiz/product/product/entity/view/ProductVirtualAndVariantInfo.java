package org.apache.ofbiz.product.product.entity.view;

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

	public static final long serialVersionUID = 1871481062605618176L;
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
	 * Product Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String productFeatureApplTypeId;
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
	 * Product Price Type Id
	 */
	@Getter
	@Setter
	private String productPriceTypeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
	/**
	 * Price
	 */
	@Getter
	@Setter
	private BigDecimal price;

	public enum Fields {
		productId, productName, internalName, productAssocTypeId, fromDate, thruDate, productFeatureApplTypeId, productFeatureId, productFeatureTypeId, productFeatureCategoryId, description, productPriceTypeId, currencyUomId, productStoreGroupId, price
	}

	public ProductVirtualAndVariantInfo(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productName = (String) value.get(Fields.productName.name());
		internalName = (String) value.get(Fields.internalName.name());
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productFeatureTypeId = (String) value.get(Fields.productFeatureTypeId
				.name());
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		description = (String) value.get(Fields.description.name());
		productPriceTypeId = (String) value.get(Fields.productPriceTypeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		price = (BigDecimal) value.get(Fields.price.name());
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