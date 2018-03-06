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
 * Product Price
 */
public class ProductPrice implements Serializable {

	public static final long serialVersionUID = 4195225683674556416L;
	public static final String NAME = "ProductPrice";
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
	 * Term Uom Id
	 */
	@Getter
	@Setter
	private String termUomId;
	/**
	 * Custom Price Calc Service
	 */
	@Getter
	@Setter
	private String customPriceCalcService;
	/**
	 * Price Without Tax
	 */
	@Getter
	@Setter
	private BigDecimal priceWithoutTax;
	/**
	 * Price With Tax
	 */
	@Getter
	@Setter
	private BigDecimal priceWithTax;
	/**
	 * Tax Amount
	 */
	@Getter
	@Setter
	private BigDecimal taxAmount;
	/**
	 * Tax Percentage
	 */
	@Getter
	@Setter
	private BigDecimal taxPercentage;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax In Price
	 */
	@Getter
	@Setter
	private String taxInPrice;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;

	public enum Fields {
		productId, productPriceTypeId, productPricePurposeId, currencyUomId, productStoreGroupId, fromDate, thruDate, price, termUomId, customPriceCalcService, priceWithoutTax, priceWithTax, taxAmount, taxPercentage, taxAuthPartyId, taxAuthGeoId, taxInPrice, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public ProductPrice(GenericValue value) {
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
		termUomId = (String) value.get(Fields.termUomId.name());
		customPriceCalcService = (String) value
				.get(Fields.customPriceCalcService.name());
		priceWithoutTax = (BigDecimal) value.get(Fields.priceWithoutTax.name());
		priceWithTax = (BigDecimal) value.get(Fields.priceWithTax.name());
		taxAmount = (BigDecimal) value.get(Fields.taxAmount.name());
		taxPercentage = (BigDecimal) value.get(Fields.taxPercentage.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxInPrice = (String) value.get(Fields.taxInPrice.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
	}

	public static ProductPrice fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPrice(value);
	}

	public static List<ProductPrice> fromValues(List<GenericValue> values) {
		List<ProductPrice> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPrice(value));
		}
		return entities;
	}
}