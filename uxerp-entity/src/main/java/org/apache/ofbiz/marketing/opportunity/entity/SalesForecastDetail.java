package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Forecast Detail
 */
public class SalesForecastDetail implements Serializable {

	public static final long serialVersionUID = 7065313932006778880L;
	public static final String NAME = "SalesForecastDetail";
	/**
	 * Sales Forecast Id
	 */
	@Getter
	@Setter
	private String salesForecastId;
	/**
	 * Sales Forecast Detail Id
	 */
	@Getter
	@Setter
	private String salesForecastDetailId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;

	public enum Fields {
		salesForecastId, salesForecastDetailId, amount, quantityUomId, quantity, productId, productCategoryId
	}

	public SalesForecastDetail(GenericValue value) {
		salesForecastId = (String) value.get(Fields.salesForecastId.name());
		salesForecastDetailId = (String) value.get(Fields.salesForecastDetailId
				.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
	}

	public static SalesForecastDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesForecastDetail(value);
	}

	public static List<SalesForecastDetail> fromValues(List<GenericValue> values) {
		List<SalesForecastDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesForecastDetail(value));
		}
		return entities;
	}
}