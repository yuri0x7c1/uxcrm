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
 * Product Price Change
 */
@FieldNameConstants
public class ProductPriceChange implements Serializable {

	public static final long serialVersionUID = 8556939628527959040L;
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

	public ProductPriceChange(GenericValue value) {
		productPriceChangeId = (String) value
				.get(FIELD_PRODUCT_PRICE_CHANGE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productPriceTypeId = (String) value.get(FIELD_PRODUCT_PRICE_TYPE_ID);
		productPricePurposeId = (String) value
				.get(FIELD_PRODUCT_PRICE_PURPOSE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		productStoreGroupId = (String) value.get(FIELD_PRODUCT_STORE_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		price = (BigDecimal) value.get(FIELD_PRICE);
		oldPrice = (BigDecimal) value.get(FIELD_OLD_PRICE);
		changedDate = (Timestamp) value.get(FIELD_CHANGED_DATE);
		changedByUserLogin = (String) value.get(FIELD_CHANGED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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