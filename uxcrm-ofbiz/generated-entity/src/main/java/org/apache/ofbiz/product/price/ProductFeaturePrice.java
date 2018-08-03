package org.apache.ofbiz.product.price;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Price
 */
public class ProductFeaturePrice implements Serializable {

	public static final long serialVersionUID = 248156508309502976L;
	public static final String NAME = "ProductFeaturePrice";
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
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

	public enum Fields {
		productFeatureId, productPriceTypeId, currencyUomId, fromDate, thruDate, price, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeaturePrice(GenericValue value) {
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productPriceTypeId = (String) value.get(Fields.productPriceTypeId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		price = (BigDecimal) value.get(Fields.price.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFeaturePrice fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeaturePrice(value);
	}

	public static List<ProductFeaturePrice> fromValues(List<GenericValue> values) {
		List<ProductFeaturePrice> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeaturePrice(value));
		}
		return entities;
	}
}