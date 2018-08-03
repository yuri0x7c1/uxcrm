package org.apache.ofbiz.marketing.opportunity;

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
public class SalesForecast implements Serializable {

	public static final long serialVersionUID = 3173093778665291776L;
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

	public enum Fields {
		salesForecastId, parentSalesForecastId, organizationPartyId, internalPartyId, customTimePeriodId, currencyUomId, quotaAmount, forecastAmount, bestCaseAmount, closedAmount, percentOfQuotaForecast, percentOfQuotaClosed, pipelineAmount, createdByUserLoginId, modifiedByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalesForecast(GenericValue value) {
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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