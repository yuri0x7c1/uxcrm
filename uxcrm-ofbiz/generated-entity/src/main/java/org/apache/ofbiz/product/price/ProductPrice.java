package org.apache.ofbiz.product.price;

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
 * Product Price
 */
@FieldNameConstants
public class ProductPrice implements Serializable {

	public static final long serialVersionUID = 9164586384257006592L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public ProductPrice(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productPriceTypeId = (String) value.get(FIELD_PRODUCT_PRICE_TYPE_ID);
		productPricePurposeId = (String) value
				.get(FIELD_PRODUCT_PRICE_PURPOSE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		productStoreGroupId = (String) value.get(FIELD_PRODUCT_STORE_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		price = (BigDecimal) value.get(FIELD_PRICE);
		termUomId = (String) value.get(FIELD_TERM_UOM_ID);
		customPriceCalcService = (String) value
				.get(FIELD_CUSTOM_PRICE_CALC_SERVICE);
		priceWithoutTax = (BigDecimal) value.get(FIELD_PRICE_WITHOUT_TAX);
		priceWithTax = (BigDecimal) value.get(FIELD_PRICE_WITH_TAX);
		taxAmount = (BigDecimal) value.get(FIELD_TAX_AMOUNT);
		taxPercentage = (BigDecimal) value.get(FIELD_TAX_PERCENTAGE);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxInPrice = (String) value.get(FIELD_TAX_IN_PRICE);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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