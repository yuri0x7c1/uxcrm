package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Change
 */
public class ProductPriceChange implements Serializable {

	public static final long serialVersionUID = 2392712534854263808L;
	public static final String NAME = "ProductPriceChange";
	/**
	 * Product Price Change Id
	 */
	@Getter
	@Setter
	private String productPriceChangeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
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
	/**
	 * Old Price
	 */
	@Getter
	@Setter
	private BigDecimal oldPrice;
	/**
	 * Changed Date
	 */
	@Getter
	@Setter
	private Timestamp changedDate;
	/**
	 * Changed By User Login
	 */
	@Getter
	@Setter
	private String changedByUserLogin;

	public enum Fields {
		productPriceChangeId, productId, productPriceTypeId, productPricePurposeId, currencyUomId, productStoreGroupId, fromDate, thruDate, price, oldPrice, changedDate, changedByUserLogin
	}

	public ProductPriceChange(GenericValue value) {
		productPriceChangeId = (String) value.get(Fields.productPriceChangeId
				.name());
		productId = (String) value.get(Fields.productId.name());
		productPriceTypeId = (String) value.get(Fields.productPriceTypeId
				.name());
		productPricePurposeId = (String) value.get(Fields.productPricePurposeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		price = (BigDecimal) value.get(Fields.price.name());
		oldPrice = (BigDecimal) value.get(Fields.oldPrice.name());
		changedDate = (Timestamp) value.get(Fields.changedDate.name());
		changedByUserLogin = (String) value.get(Fields.changedByUserLogin
				.name());
	}

	public static ProductPriceChange fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceChange(value);
	}

	public static List<ProductPriceChange> fromValues(List<GenericValue> values) {
		List<ProductPriceChange> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceChange(value));
		}
		return entities;
	}
}