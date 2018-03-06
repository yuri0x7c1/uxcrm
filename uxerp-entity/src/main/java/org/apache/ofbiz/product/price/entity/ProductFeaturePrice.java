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
 * Product Feature Price
 */
public class ProductFeaturePrice implements Serializable {

	public static final long serialVersionUID = 2371096183897982976L;
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

	public enum Fields {
		productFeatureId, productPriceTypeId, currencyUomId, fromDate, thruDate, price, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
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