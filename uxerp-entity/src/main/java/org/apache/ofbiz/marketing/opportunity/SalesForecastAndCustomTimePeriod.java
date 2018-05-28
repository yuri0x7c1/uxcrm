package org.apache.ofbiz.marketing.opportunity;

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
public class SalesForecastAndCustomTimePeriod implements Serializable {

	public static final long serialVersionUID = 1662940916093693952L;
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

	public enum Fields {
		forecastAmount, pipelineAmount, modifiedByUserLoginId, quotaAmount, bestCaseAmount, createdByUserLoginId, internalPartyId, closedAmount, salesForecastId, percentOfQuotaForecast, currencyUomId, parentSalesForecastId, organizationPartyId, percentOfQuotaClosed, customTimePeriodId, periodNum, periodTypeId, periodName, parentPeriodId, thruDate, fromDate, isClosed
	}

	public SalesForecastAndCustomTimePeriod(GenericValue value) {
		forecastAmount = (BigDecimal) value.get(Fields.forecastAmount.name());
		pipelineAmount = (BigDecimal) value.get(Fields.pipelineAmount.name());
		modifiedByUserLoginId = (String) value.get(Fields.modifiedByUserLoginId
				.name());
		quotaAmount = (BigDecimal) value.get(Fields.quotaAmount.name());
		bestCaseAmount = (BigDecimal) value.get(Fields.bestCaseAmount.name());
		createdByUserLoginId = (String) value.get(Fields.createdByUserLoginId
				.name());
		internalPartyId = (String) value.get(Fields.internalPartyId.name());
		closedAmount = (BigDecimal) value.get(Fields.closedAmount.name());
		salesForecastId = (String) value.get(Fields.salesForecastId.name());
		percentOfQuotaForecast = (BigDecimal) value
				.get(Fields.percentOfQuotaForecast.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		parentSalesForecastId = (String) value.get(Fields.parentSalesForecastId
				.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		percentOfQuotaClosed = (BigDecimal) value
				.get(Fields.percentOfQuotaClosed.name());
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		periodNum = (Long) value.get(Fields.periodNum.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		periodName = (String) value.get(Fields.periodName.name());
		parentPeriodId = (String) value.get(Fields.parentPeriodId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		isClosed = (String) value.get(Fields.isClosed.name());
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