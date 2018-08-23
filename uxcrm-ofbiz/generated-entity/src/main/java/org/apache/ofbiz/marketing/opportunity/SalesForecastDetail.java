package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Forecast Detail
 */
@FieldNameConstants
public class SalesForecastDetail implements Serializable {

	public static final long serialVersionUID = 1515259514088236032L;
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

	public SalesForecastDetail(GenericValue value) {
		salesForecastId = (String) value.get(FIELD_SALES_FORECAST_ID);
		salesForecastDetailId = (String) value
				.get(FIELD_SALES_FORECAST_DETAIL_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		quantityUomId = (String) value.get(FIELD_QUANTITY_UOM_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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