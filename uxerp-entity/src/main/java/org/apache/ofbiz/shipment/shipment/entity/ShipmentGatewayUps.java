package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Gateway Ups
 */
public class ShipmentGatewayUps implements Serializable {

	public static final long serialVersionUID = 8054758627946240000L;
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

	public enum Fields {
		shipmentGatewayConfigId, connectUrl, connectTimeout, shipperNumber, billShipperAccountNumber, accessLicenseNumber, accessUserId, accessPassword, saveCertInfo, saveCertPath, shipperPickupType, customerClassification, maxEstimateWeight, minEstimateWeight, codAllowCod, codSurchargeAmount, codSurchargeCurrencyUomId, codSurchargeApplyToPackage, codFundsCode, defaultReturnLabelMemo, defaultReturnLabelSubject
	}

	public ShipmentGatewayUps(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		connectUrl = (String) value.get(Fields.connectUrl.name());
		connectTimeout = (Long) value.get(Fields.connectTimeout.name());
		shipperNumber = (String) value.get(Fields.shipperNumber.name());
		billShipperAccountNumber = (String) value
				.get(Fields.billShipperAccountNumber.name());
		accessLicenseNumber = (String) value.get(Fields.accessLicenseNumber
				.name());
		accessUserId = (String) value.get(Fields.accessUserId.name());
		accessPassword = (String) value.get(Fields.accessPassword.name());
		saveCertInfo = (String) value.get(Fields.saveCertInfo.name());
		saveCertPath = (String) value.get(Fields.saveCertPath.name());
		shipperPickupType = (String) value.get(Fields.shipperPickupType.name());
		customerClassification = (String) value
				.get(Fields.customerClassification.name());
		maxEstimateWeight = (BigDecimal) value.get(Fields.maxEstimateWeight
				.name());
		minEstimateWeight = (BigDecimal) value.get(Fields.minEstimateWeight
				.name());
		codAllowCod = (String) value.get(Fields.codAllowCod.name());
		codSurchargeAmount = (BigDecimal) value.get(Fields.codSurchargeAmount
				.name());
		codSurchargeCurrencyUomId = (String) value
				.get(Fields.codSurchargeCurrencyUomId.name());
		codSurchargeApplyToPackage = (String) value
				.get(Fields.codSurchargeApplyToPackage.name());
		codFundsCode = (String) value.get(Fields.codFundsCode.name());
		defaultReturnLabelMemo = (String) value
				.get(Fields.defaultReturnLabelMemo.name());
		defaultReturnLabelSubject = (String) value
				.get(Fields.defaultReturnLabelSubject.name());
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