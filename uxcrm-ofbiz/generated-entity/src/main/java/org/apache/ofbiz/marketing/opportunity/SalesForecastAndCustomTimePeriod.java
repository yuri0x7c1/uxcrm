package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Forecast And Custom Time Period
 */
@FieldNameConstants
public class SalesForecastAndCustomTimePeriod implements Serializable {

	public static final long serialVersionUID = 1239017908213595136L;
	public static final String NAME = "SalesForecastAndCustomTimePeriod";
	/**
	 * Forecast Amount
	 */
	@Getter
	@Setter
	private BigDecimal forecastAmount;
	/**
	 * Pipeline Amount
	 */
	@Getter
	@Setter
	private BigDecimal pipelineAmount;
	/**
	 * Modified By User Login Id
	 */
	@Getter
	@Setter
	private String modifiedByUserLoginId;
	/**
	 * Quota Amount
	 */
	@Getter
	@Setter
	private BigDecimal quotaAmount;
	/**
	 * Best Case Amount
	 */
	@Getter
	@Setter
	private BigDecimal bestCaseAmount;
	/**
	 * Created By User Login Id
	 */
	@Getter
	@Setter
	private String createdByUserLoginId;
	/**
	 * Internal Party Id
	 */
	@Getter
	@Setter
	private String internalPartyId;
	/**
	 * Closed Amount
	 */
	@Getter
	@Setter
	private BigDecimal closedAmount;
	/**
	 * Sales Forecast Id
	 */
	@Getter
	@Setter
	private String salesForecastId;
	/**
	 * Percent Of Quota Forecast
	 */
	@Getter
	@Setter
	private BigDecimal percentOfQuotaForecast;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
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
	 * Percent Of Quota Closed
	 */
	@Getter
	@Setter
	private BigDecimal percentOfQuotaClosed;
	/**
	 * Custom Time Period Id
	 */
	@Getter
	@Setter
	private String customTimePeriodId;
	/**
	 * Period Num
	 */
	@Getter
	@Setter
	private Long periodNum;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Period Name
	 */
	@Getter
	@Setter
	private String periodName;
	/**
	 * Parent Period Id
	 */
	@Getter
	@Setter
	private String parentPeriodId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Is Closed
	 */
	@Getter
	@Setter
	private String isClosed;

	public SalesForecastAndCustomTimePeriod(GenericValue value) {
		forecastAmount = (BigDecimal) value.get(FIELD_FORECAST_AMOUNT);
		pipelineAmount = (BigDecimal) value.get(FIELD_PIPELINE_AMOUNT);
		modifiedByUserLoginId = (String) value
				.get(FIELD_MODIFIED_BY_USER_LOGIN_ID);
		quotaAmount = (BigDecimal) value.get(FIELD_QUOTA_AMOUNT);
		bestCaseAmount = (BigDecimal) value.get(FIELD_BEST_CASE_AMOUNT);
		createdByUserLoginId = (String) value
				.get(FIELD_CREATED_BY_USER_LOGIN_ID);
		internalPartyId = (String) value.get(FIELD_INTERNAL_PARTY_ID);
		closedAmount = (BigDecimal) value.get(FIELD_CLOSED_AMOUNT);
		salesForecastId = (String) value.get(FIELD_SALES_FORECAST_ID);
		percentOfQuotaForecast = (BigDecimal) value
				.get(FIELD_PERCENT_OF_QUOTA_FORECAST);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		parentSalesForecastId = (String) value
				.get(FIELD_PARENT_SALES_FORECAST_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		percentOfQuotaClosed = (BigDecimal) value
				.get(FIELD_PERCENT_OF_QUOTA_CLOSED);
		customTimePeriodId = (String) value.get(FIELD_CUSTOM_TIME_PERIOD_ID);
		periodNum = (Long) value.get(FIELD_PERIOD_NUM);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		periodName = (String) value.get(FIELD_PERIOD_NAME);
		parentPeriodId = (String) value.get(FIELD_PARENT_PERIOD_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		isClosed = (String) value.get(FIELD_IS_CLOSED);
	}

	public static SalesForecastAndCustomTimePeriod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesForecastAndCustomTimePeriod(value);
	}

	public static List<SalesForecastAndCustomTimePeriod> fromValues(
			List<GenericValue> values) {
		List<SalesForecastAndCustomTimePeriod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesForecastAndCustomTimePeriod(value));
		}
		return entities;
	}
}