package org.apache.ofbiz.product.store;

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
 * Product Store Fin Act Setting
 */
@FieldNameConstants
public class ProductStoreFinActSetting implements Serializable {

	public static final long serialVersionUID = 6307727715648299008L;
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

	public ProductStoreFinActSetting(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		finAccountTypeId = (String) value.get(FIELD_FIN_ACCOUNT_TYPE_ID);
		requirePinCode = (String) value.get(FIELD_REQUIRE_PIN_CODE);
		validateGCFinAcct = (String) value.get(FIELD_VALIDATE_G_C_FIN_ACCT);
		accountCodeLength = (Long) value.get(FIELD_ACCOUNT_CODE_LENGTH);
		pinCodeLength = (Long) value.get(FIELD_PIN_CODE_LENGTH);
		accountValidDays = (Long) value.get(FIELD_ACCOUNT_VALID_DAYS);
		authValidDays = (Long) value.get(FIELD_AUTH_VALID_DAYS);
		purchaseSurveyId = (String) value.get(FIELD_PURCHASE_SURVEY_ID);
		purchSurveySendTo = (String) value.get(FIELD_PURCH_SURVEY_SEND_TO);
		purchSurveyCopyMe = (String) value.get(FIELD_PURCH_SURVEY_COPY_ME);
		allowAuthToNegative = (String) value.get(FIELD_ALLOW_AUTH_TO_NEGATIVE);
		minBalance = (BigDecimal) value.get(FIELD_MIN_BALANCE);
		replenishThreshold = (BigDecimal) value.get(FIELD_REPLENISH_THRESHOLD);
		replenishMethodEnumId = (String) value
				.get(FIELD_REPLENISH_METHOD_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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