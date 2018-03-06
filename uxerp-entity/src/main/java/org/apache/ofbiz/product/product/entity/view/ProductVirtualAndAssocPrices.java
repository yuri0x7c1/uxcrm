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
 * Product Virtual And Assoc Prices
 */
public class ProductVirtualAndAssocPrices implements Serializable {

	public static final long serialVersionUID = 742835472747892736L;
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
		productId, internalName, productName, productAssocTypeId, fromDate, thruDate, productPriceTypeId, currencyUomId, productStoreGroupId, price
	}

	public ProductVirtualAndAssocPrices(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		internalName = (String) value.get(Fields.internalName.name());
		productName = (String) value.get(Fields.productName.name());
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		productPriceTypeId = (String) value.get(Fields.productPriceTypeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		price = (BigDecimal) value.get(Fields.price.name());
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