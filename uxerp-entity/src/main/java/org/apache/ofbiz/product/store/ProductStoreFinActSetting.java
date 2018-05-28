package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Fin Act Setting
 */
public class ProductStoreFinActSetting implements Serializable {

	public static final long serialVersionUID = 5646300114182549504L;
	public static final String NAME = "ProductStoreFinActSetting";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
	/**
	 * Require Pin Code
	 */
	@Getter
	@Setter
	private String requirePinCode;
	/**
	 * Validate Gc Fin Acct
	 */
	@Getter
	@Setter
	private String validateGCFinAcct;
	/**
	 * Account Code Length
	 */
	@Getter
	@Setter
	private Long accountCodeLength;
	/**
	 * Pin Code Length
	 */
	@Getter
	@Setter
	private Long pinCodeLength;
	/**
	 * Account Valid Days
	 */
	@Getter
	@Setter
	private Long accountValidDays;
	/**
	 * Auth Valid Days
	 */
	@Getter
	@Setter
	private Long authValidDays;
	/**
	 * Purchase Survey Id
	 */
	@Getter
	@Setter
	private String purchaseSurveyId;
	/**
	 * Purch Survey Send To
	 */
	@Getter
	@Setter
	private String purchSurveySendTo;
	/**
	 * Purch Survey Copy Me
	 */
	@Getter
	@Setter
	private String purchSurveyCopyMe;
	/**
	 * Allow Auth To Negative
	 */
	@Getter
	@Setter
	private String allowAuthToNegative;
	/**
	 * Min Balance
	 */
	@Getter
	@Setter
	private BigDecimal minBalance;
	/**
	 * Replenish Threshold
	 */
	@Getter
	@Setter
	private BigDecimal replenishThreshold;
	/**
	 * Replenish Method Enum Id
	 */
	@Getter
	@Setter
	private String replenishMethodEnumId;
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
		productStoreId, finAccountTypeId, requirePinCode, validateGCFinAcct, accountCodeLength, pinCodeLength, accountValidDays, authValidDays, purchaseSurveyId, purchSurveySendTo, purchSurveyCopyMe, allowAuthToNegative, minBalance, replenishThreshold, replenishMethodEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreFinActSetting(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		requirePinCode = (String) value.get(Fields.requirePinCode.name());
		validateGCFinAcct = (String) value.get(Fields.validateGCFinAcct.name());
		accountCodeLength = (Long) value.get(Fields.accountCodeLength.name());
		pinCodeLength = (Long) value.get(Fields.pinCodeLength.name());
		accountValidDays = (Long) value.get(Fields.accountValidDays.name());
		authValidDays = (Long) value.get(Fields.authValidDays.name());
		purchaseSurveyId = (String) value.get(Fields.purchaseSurveyId.name());
		purchSurveySendTo = (String) value.get(Fields.purchSurveySendTo.name());
		purchSurveyCopyMe = (String) value.get(Fields.purchSurveyCopyMe.name());
		allowAuthToNegative = (String) value.get(Fields.allowAuthToNegative
				.name());
		minBalance = (BigDecimal) value.get(Fields.minBalance.name());
		replenishThreshold = (BigDecimal) value.get(Fields.replenishThreshold
				.name());
		replenishMethodEnumId = (String) value.get(Fields.replenishMethodEnumId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStoreFinActSetting fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreFinActSetting(value);
	}

	public static List<ProductStoreFinActSetting> fromValues(
			List<GenericValue> values) {
		List<ProductStoreFinActSetting> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreFinActSetting(value));
		}
		return entities;
	}
}