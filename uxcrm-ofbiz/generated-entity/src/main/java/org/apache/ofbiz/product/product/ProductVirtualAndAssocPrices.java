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
 * Product Virtual And Assoc Prices
 */
@FieldNameConstants
public class ProductVirtualAndAssocPrices implements Serializable {

	public static final long serialVersionUID = 8273199498507579392L;
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

	public ProductVirtualAndAssocPrices(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		productAssocTypeId = (String) value.get(FIELD_PRODUCT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		assocProductId = (String) value.get(FIELD_ASSOC_PRODUCT_ID);
		assocProductCount = (Long) value.get(FIELD_ASSOC_PRODUCT_COUNT);
		assocPriceTypeId = (String) value.get(FIELD_ASSOC_PRICE_TYPE_ID);
		assocCurrencyUomId = (String) value.get(FIELD_ASSOC_CURRENCY_UOM_ID);
		assocProductStoreGroupId = (String) value
				.get(FIELD_ASSOC_PRODUCT_STORE_GROUP_ID);
		assocPriceFromDate = (Timestamp) value.get(FIELD_ASSOC_PRICE_FROM_DATE);
		assocPriceThruDate = (Timestamp) value.get(FIELD_ASSOC_PRICE_THRU_DATE);
		assocMinPrice = (BigDecimal) value.get(FIELD_ASSOC_MIN_PRICE);
		assocMaxPrice = (BigDecimal) value.get(FIELD_ASSOC_MAX_PRICE);
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