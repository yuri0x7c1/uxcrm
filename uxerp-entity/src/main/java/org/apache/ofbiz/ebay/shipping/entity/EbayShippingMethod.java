package org.apache.ofbiz.ebay.shipping.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Ebay Shipping Method
 */
public class EbayShippingMethod implements Serializable {

	public static final long serialVersionUID = 1726814621220543488L;
	public static final String NAME = "EbayShippingMethod";
	/**
	 * Shipment Method Name
	 */
	@Getter
	@Setter
	private String shipmentMethodName;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Additional Amount
	 */
	@Getter
	@Setter
	private BigDecimal additionalAmount;
	/**
	 * Additional Percent
	 */
	@Getter
	@Setter
	private BigDecimal additionalPercent;
	/**
	 * Method Type Enum Id
	 */
	@Getter
	@Setter
	private String methodTypeEnumId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;

	public enum Fields {
		shipmentMethodName, productStoreId, amount, additionalAmount, additionalPercent, methodTypeEnumId, carrierPartyId, shipmentMethodTypeId
	}

	public EbayShippingMethod(GenericValue value) {
		shipmentMethodName = (String) value.get(Fields.shipmentMethodName
				.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		additionalAmount = (BigDecimal) value.get(Fields.additionalAmount
				.name());
		additionalPercent = (BigDecimal) value.get(Fields.additionalPercent
				.name());
		methodTypeEnumId = (String) value.get(Fields.methodTypeEnumId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
	}

	public static EbayShippingMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EbayShippingMethod(value);
	}

	public static List<EbayShippingMethod> fromValues(List<GenericValue> values) {
		List<EbayShippingMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EbayShippingMethod(value));
		}
		return entities;
	}
}