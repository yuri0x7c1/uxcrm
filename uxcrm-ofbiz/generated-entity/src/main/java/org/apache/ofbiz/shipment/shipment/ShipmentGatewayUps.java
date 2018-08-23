package org.apache.ofbiz.shipment.shipment;

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
 * Shipment Gateway Ups
 */
@FieldNameConstants
public class ShipmentGatewayUps implements Serializable {

	public static final long serialVersionUID = 1420042026231043072L;
	public static final String NAME = "ShipmentGatewayUps";
	/**
	 * Shipment Gateway Config Id
	 */
	@Getter
	@Setter
	private String shipmentGatewayConfigId;
	/**
	 * Connect Url
	 */
	@Getter
	@Setter
	private String connectUrl;
	/**
	 * Connect Timeout
	 */
	@Getter
	@Setter
	private Long connectTimeout;
	/**
	 * Shipper Number
	 */
	@Getter
	@Setter
	private String shipperNumber;
	/**
	 * Bill Shipper Account Number
	 */
	@Getter
	@Setter
	private String billShipperAccountNumber;
	/**
	 * Access License Number
	 */
	@Getter
	@Setter
	private String accessLicenseNumber;
	/**
	 * Access User Id
	 */
	@Getter
	@Setter
	private String accessUserId;
	/**
	 * Access Password
	 */
	@Getter
	@Setter
	private String accessPassword;
	/**
	 * Save Cert Info
	 */
	@Getter
	@Setter
	private String saveCertInfo;
	/**
	 * Save Cert Path
	 */
	@Getter
	@Setter
	private String saveCertPath;
	/**
	 * Shipper Pickup Type
	 */
	@Getter
	@Setter
	private String shipperPickupType;
	/**
	 * Customer Classification
	 */
	@Getter
	@Setter
	private String customerClassification;
	/**
	 * Max Estimate Weight
	 */
	@Getter
	@Setter
	private BigDecimal maxEstimateWeight;
	/**
	 * Min Estimate Weight
	 */
	@Getter
	@Setter
	private BigDecimal minEstimateWeight;
	/**
	 * Cod Allow Cod
	 */
	@Getter
	@Setter
	private String codAllowCod;
	/**
	 * Cod Surcharge Amount
	 */
	@Getter
	@Setter
	private BigDecimal codSurchargeAmount;
	/**
	 * Cod Surcharge Currency Uom Id
	 */
	@Getter
	@Setter
	private String codSurchargeCurrencyUomId;
	/**
	 * Cod Surcharge Apply To Package
	 */
	@Getter
	@Setter
	private String codSurchargeApplyToPackage;
	/**
	 * Cod Funds Code
	 */
	@Getter
	@Setter
	private String codFundsCode;
	/**
	 * Default Return Label Memo
	 */
	@Getter
	@Setter
	private String defaultReturnLabelMemo;
	/**
	 * Default Return Label Subject
	 */
	@Getter
	@Setter
	private String defaultReturnLabelSubject;
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

	public ShipmentGatewayUps(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONFIG_ID);
		connectUrl = (String) value.get(FIELD_CONNECT_URL);
		connectTimeout = (Long) value.get(FIELD_CONNECT_TIMEOUT);
		shipperNumber = (String) value.get(FIELD_SHIPPER_NUMBER);
		billShipperAccountNumber = (String) value
				.get(FIELD_BILL_SHIPPER_ACCOUNT_NUMBER);
		accessLicenseNumber = (String) value.get(FIELD_ACCESS_LICENSE_NUMBER);
		accessUserId = (String) value.get(FIELD_ACCESS_USER_ID);
		accessPassword = (String) value.get(FIELD_ACCESS_PASSWORD);
		saveCertInfo = (String) value.get(FIELD_SAVE_CERT_INFO);
		saveCertPath = (String) value.get(FIELD_SAVE_CERT_PATH);
		shipperPickupType = (String) value.get(FIELD_SHIPPER_PICKUP_TYPE);
		customerClassification = (String) value
				.get(FIELD_CUSTOMER_CLASSIFICATION);
		maxEstimateWeight = (BigDecimal) value.get(FIELD_MAX_ESTIMATE_WEIGHT);
		minEstimateWeight = (BigDecimal) value.get(FIELD_MIN_ESTIMATE_WEIGHT);
		codAllowCod = (String) value.get(FIELD_COD_ALLOW_COD);
		codSurchargeAmount = (BigDecimal) value.get(FIELD_COD_SURCHARGE_AMOUNT);
		codSurchargeCurrencyUomId = (String) value
				.get(FIELD_COD_SURCHARGE_CURRENCY_UOM_ID);
		codSurchargeApplyToPackage = (String) value
				.get(FIELD_COD_SURCHARGE_APPLY_TO_PACKAGE);
		codFundsCode = (String) value.get(FIELD_COD_FUNDS_CODE);
		defaultReturnLabelMemo = (String) value
				.get(FIELD_DEFAULT_RETURN_LABEL_MEMO);
		defaultReturnLabelSubject = (String) value
				.get(FIELD_DEFAULT_RETURN_LABEL_SUBJECT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentGatewayUps fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentGatewayUps(value);
	}

	public static List<ShipmentGatewayUps> fromValues(List<GenericValue> values) {
		List<ShipmentGatewayUps> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentGatewayUps(value));
		}
		return entities;
	}
}