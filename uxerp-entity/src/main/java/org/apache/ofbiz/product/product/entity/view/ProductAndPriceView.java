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
 * Product And Price View
 */
public class ProductAndPriceView implements Serializable {

	public static final long serialVersionUID = 4106424704796983296L;
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

	public enum Fields {
		productId, productTypeId, productName, internalName, description, primaryProductCategoryId, isVirtual, productPriceTypeId, productPricePurposeId, currencyUomId, fromDate, thruDate, price
	}

	public ProductAndPriceView(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productTypeId = (String) value.get(Fields.productTypeId.name());
		productName = (String) value.get(Fields.productName.name());
		internalName = (String) value.get(Fields.internalName.name());
		description = (String) value.get(Fields.description.name());
		primaryProductCategoryId = (String) value
				.get(Fields.primaryProductCategoryId.name());
		isVirtual = (String) value.get(Fields.isVirtual.name());
		productPriceTypeId = (String) value.get(Fields.productPriceTypeId
				.name());
		productPricePurposeId = (String) value.get(Fields.productPricePurposeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		price = (BigDecimal) value.get(Fields.price.name());
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