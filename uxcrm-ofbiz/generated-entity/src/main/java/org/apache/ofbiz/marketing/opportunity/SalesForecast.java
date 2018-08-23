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
 * Sales Forecast
 */
@FieldNameConstants
public class SalesForecast implements Serializable {

	public static final long serialVersionUID = 4096486841734769664L;
	public static final String NAME = "SalesForecast";
	/**
	 * Sales Forecast Id
	 */
	@Getter
	@Setter
	private String salesForecastId;
	/**
	 * Parent Sales Forecast Id
	 */
	@Getter
	@Setter
	private String parentSalesForecastId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Internal Party Id
	 */
	@Getter
	@Setter
	private String internalPartyId;
	/**
	 * Custom Time Period Id
	 */
	@Getter
	@Setter
	private String customTimePeriodId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Quota Amount
	 */
	@Getter
	@Setter
	private BigDecimal quotaAmount;
	/**
	 * Forecast Amount
	 */
	@Getter
	@Setter
	private BigDecimal forecastAmount;
	/**
	 * Best Case Amount
	 */
	@Getter
	@Setter
	private BigDecimal bestCaseAmount;
	/**
	 * Closed Amount
	 */
	@Getter
	@Setter
	private BigDecimal closedAmount;
	/**
	 * Percent Of Quota Forecast
	 */
	@Getter
	@Setter
	private BigDecimal percentOfQuotaForecast;
	/**
	 * Percent Of Quota Closed
	 */
	@Getter
	@Setter
	private BigDecimal percentOfQuotaClosed;
	/**
	 * Pipeline Amount
	 */
	@Getter
	@Setter
	private BigDecimal pipelineAmount;
	/**
	 * Created By User Login Id
	 */
	@Getter
	@Setter
	private String createdByUserLoginId;
	/**
	 * Modified By User Login Id
	 */
	@Getter
	@Setter
	private String modifiedByUserLoginId;
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

	public SalesForecast(GenericValue value) {
		salesForecastId = (String) value.get(FIELD_SALES_FORECAST_ID);
		parentSalesForecastId = (String) value
				.get(FIELD_PARENT_SALES_FORECAST_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		internalPartyId = (String) value.get(FIELD_INTERNAL_PARTY_ID);
		customTimePeriodId = (String) value.get(FIELD_CUSTOM_TIME_PERIOD_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		quotaAmount = (BigDecimal) value.get(FIELD_QUOTA_AMOUNT);
		forecastAmount = (BigDecimal) value.get(FIELD_FORECAST_AMOUNT);
		bestCaseAmount = (BigDecimal) value.get(FIELD_BEST_CASE_AMOUNT);
		closedAmount = (BigDecimal) value.get(FIELD_CLOSED_AMOUNT);
		percentOfQuotaForecast = (BigDecimal) value
				.get(FIELD_PERCENT_OF_QUOTA_FORECAST);
		percentOfQuotaClosed = (BigDecimal) value
				.get(FIELD_PERCENT_OF_QUOTA_CLOSED);
		pipelineAmount = (BigDecimal) value.get(FIELD_PIPELINE_AMOUNT);
		createdByUserLoginId = (String) value
				.get(FIELD_CREATED_BY_USER_LOGIN_ID);
		modifiedByUserLoginId = (String) value
				.get(FIELD_MODIFIED_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SalesForecast fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesForecast(value);
	}

	public static List<SalesForecast> fromValues(List<GenericValue> values) {
		List<SalesForecast> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesForecast(value));
		}
		return entities;
	}
}