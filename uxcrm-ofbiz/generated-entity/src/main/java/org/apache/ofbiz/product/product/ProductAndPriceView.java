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
 * Product And Price View
 */
@FieldNameConstants
public class ProductAndPriceView implements Serializable {

	public static final long serialVersionUID = 9210654197253504000L;
	public static final String NAME = "ProductAndPriceView";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Primary Product Category Id
	 */
	@Getter
	@Setter
	private String primaryProductCategoryId;
	/**
	 * Is Virtual
	 */
	@Getter
	@Setter
	private String isVirtual;
	/**
	 * Product Price Type Id
	 */
	@Getter
	@Setter
	private String productPriceTypeId;
	/**
	 * Product Price Purpose Id
	 */
	@Getter
	@Setter
	private String productPricePurposeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
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
	 * Price
	 */
	@Getter
	@Setter
	private BigDecimal price;

	public ProductAndPriceView(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productTypeId = (String) value.get(FIELD_PRODUCT_TYPE_ID);
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		primaryProductCategoryId = (String) value
				.get(FIELD_PRIMARY_PRODUCT_CATEGORY_ID);
		isVirtual = (String) value.get(FIELD_IS_VIRTUAL);
		productPriceTypeId = (String) value.get(FIELD_PRODUCT_PRICE_TYPE_ID);
		productPricePurposeId = (String) value
				.get(FIELD_PRODUCT_PRICE_PURPOSE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		price = (BigDecimal) value.get(FIELD_PRICE);
	}

	public static ProductAndPriceView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAndPriceView(value);
	}

	public static List<ProductAndPriceView> fromValues(List<GenericValue> values) {
		List<ProductAndPriceView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAndPriceView(value));
		}
		return entities;
	}
}