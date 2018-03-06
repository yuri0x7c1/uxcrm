package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Forecast History
 */
public class SalesForecastHistory implements Serializable {

	public static final long serialVersionUID = 5821821743605680128L;
	public static final String NAME = "SalesForecastHistory";
	/**
	 * Sales Forecast History Id
	 */
	@Getter
	@Setter
	private String salesForecastHistoryId;
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
	 * Change Note
	 */
	@Getter
	@Setter
	private String changeNote;
	/**
	 * Modified By User Login Id
	 */
	@Getter
	@Setter
	private String modifiedByUserLoginId;
	/**
	 * Modified Timestamp
	 */
	@Getter
	@Setter
	private Timestamp modifiedTimestamp;

	public enum Fields {
		salesForecastHistoryId, salesForecastId, parentSalesForecastId, organizationPartyId, internalPartyId, customTimePeriodId, currencyUomId, quotaAmount, forecastAmount, bestCaseAmount, closedAmount, percentOfQuotaForecast, percentOfQuotaClosed, changeNote, modifiedByUserLoginId, modifiedTimestamp
	}

	public SalesForecastHistory(GenericValue value) {
		salesForecastHistoryId = (String) value
				.get(Fields.salesForecastHistoryId.name());
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
		changeNote = (String) value.get(Fields.changeNote.name());
		modifiedByUserLoginId = (String) value.get(Fields.modifiedByUserLoginId
				.name());
		modifiedTimestamp = (Timestamp) value.get(Fields.modifiedTimestamp
				.name());
	}

	public static SalesForecastHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesForecastHistory(value);
	}

	public static List<SalesForecastHistory> fromValues(
			List<GenericValue> values) {
		List<SalesForecastHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesForecastHistory(value));
		}
		return entities;
	}
}