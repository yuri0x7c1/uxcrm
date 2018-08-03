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
 * Product Virtual And Assoc Prices
 */
public class ProductVirtualAndAssocPrices implements Serializable {

	public static final long serialVersionUID = 2849540623227359232L;
	public static final String NAME = "ProductVirtualAndAssocPrices";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
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
	 * Assoc Product Id
	 */
	@Getter
	@Setter
	private String assocProductId;
	/**
	 * Assoc Product Count
	 */
	@Getter
	@Setter
	private Long assocProductCount;
	/**
	 * Assoc Price Type Id
	 */
	@Getter
	@Setter
	private String assocPriceTypeId;
	/**
	 * Assoc Currency Uom Id
	 */
	@Getter
	@Setter
	private String assocCurrencyUomId;
	/**
	 * Assoc Product Store Group Id
	 */
	@Getter
	@Setter
	private String assocProductStoreGroupId;
	/**
	 * Assoc Price From Date
	 */
	@Getter
	@Setter
	private Timestamp assocPriceFromDate;
	/**
	 * Assoc Price Thru Date
	 */
	@Getter
	@Setter
	private Timestamp assocPriceThruDate;
	/**
	 * Assoc Min Price
	 */
	@Getter
	@Setter
	private BigDecimal assocMinPrice;
	/**
	 * Assoc Max Price
	 */
	@Getter
	@Setter
	private BigDecimal assocMaxPrice;

	public enum Fields {
		productId, internalName, productName, productAssocTypeId, fromDate, thruDate, assocProductId, assocProductCount, assocPriceTypeId, assocCurrencyUomId, assocProductStoreGroupId, assocPriceFromDate, assocPriceThruDate, assocMinPrice, assocMaxPrice
	}

	public ProductVirtualAndAssocPrices(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		internalName = (String) value.get(Fields.internalName.name());
		productName = (String) value.get(Fields.productName.name());
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		assocProductId = (String) value.get(Fields.assocProductId.name());
		assocProductCount = (Long) value.get(Fields.assocProductCount.name());
		assocPriceTypeId = (String) value.get(Fields.assocPriceTypeId.name());
		assocCurrencyUomId = (String) value.get(Fields.assocCurrencyUomId
				.name());
		assocProductStoreGroupId = (String) value
				.get(Fields.assocProductStoreGroupId.name());
		assocPriceFromDate = (Timestamp) value.get(Fields.assocPriceFromDate
				.name());
		assocPriceThruDate = (Timestamp) value.get(Fields.assocPriceThruDate
				.name());
		assocMinPrice = (BigDecimal) value.get(Fields.assocMinPrice.name());
		assocMaxPrice = (BigDecimal) value.get(Fields.assocMaxPrice.name());
	}

	public static ProductVirtualAndAssocPrices fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductVirtualAndAssocPrices(value);
	}

	public static List<ProductVirtualAndAssocPrices> fromValues(
			List<GenericValue> values) {
		List<ProductVirtualAndAssocPrices> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductVirtualAndAssocPrices(value));
		}
		return entities;
	}
}