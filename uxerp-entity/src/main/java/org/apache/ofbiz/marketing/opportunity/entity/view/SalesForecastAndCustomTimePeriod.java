package org.apache.ofbiz.marketing.opportunity.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Forecast And Custom Time Period
 */
public class SalesForecastAndCustomTimePeriod implements Serializable {

	public static final long serialVersionUID = 7755064361322240000L;
	public static final String NAME = "SalesForecastAndCustomTimePeriod";
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
	 * Parent Period Id
	 */
	@Getter
	@Setter
	private String parentPeriodId;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Period Num
	 */
	@Getter
	@Setter
	private Long periodNum;
	/**
	 * Period Name
	 */
	@Getter
	@Setter
	private String periodName;
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
	 * Is Closed
	 */
	@Getter
	@Setter
	private String isClosed;

	public enum Fields {
		salesForecastId, parentSalesForecastId, organizationPartyId, internalPartyId, customTimePeriodId, currencyUomId, quotaAmount, forecastAmount, bestCaseAmount, closedAmount, percentOfQuotaForecast, percentOfQuotaClosed, pipelineAmount, createdByUserLoginId, modifiedByUserLoginId, parentPeriodId, periodTypeId, periodNum, periodName, fromDate, thruDate, isClosed
	}

	public SalesForecastAndCustomTimePeriod(GenericValue value) {
		salesForecastId = (String) value.get(Fields.salesForecastId.name());
		parentSalesForecastId = (String) value.get(Fields.parentSalesForecastId
				.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		internalPartyId = (String) value.get(Fields.internalPartyId.name());
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		quotaAmount = (BigDecimal) value.get(Fields.quotaAmount.name());
		forecastAmount = (BigDecimal) value.get(Fields.forecastAmount.name());
		bestCaseAmount = (BigDecimal) value.get(Fields.bestCaseAmount.name());
		closedAmount = (BigDecimal) value.get(Fields.closedAmount.name());
		percentOfQuotaForecast = (BigDecimal) value
				.get(Fields.percentOfQuotaForecast.name());
		percentOfQuotaClosed = (BigDecimal) value
				.get(Fields.percentOfQuotaClosed.name());
		pipelineAmount = (BigDecimal) value.get(Fields.pipelineAmount.name());
		createdByUserLoginId = (String) value.get(Fields.createdByUserLoginId
				.name());
		modifiedByUserLoginId = (String) value.get(Fields.modifiedByUserLoginId
				.name());
		parentPeriodId = (String) value.get(Fields.parentPeriodId.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		periodNum = (Long) value.get(Fields.periodNum.name());
		periodName = (String) value.get(Fields.periodName.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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