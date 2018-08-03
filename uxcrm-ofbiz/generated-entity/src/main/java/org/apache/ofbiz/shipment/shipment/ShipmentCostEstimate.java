package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Cost Estimate
 */
public class ShipmentCostEstimate implements Serializable {

	public static final long serialVersionUID = 222327347541538816L;
	public static final String NAME = "ShipmentCostEstimate";
	/**
	 * Shipment Cost Estimate Id
	 */
	@Getter
	@Setter
	private String shipmentCostEstimateId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Carrier Role Type Id
	 */
	@Getter
	@Setter
	private String carrierRoleTypeId;
	/**
	 * Product Store Ship Meth Id
	 */
	@Getter
	@Setter
	private String productStoreShipMethId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Geo Id To
	 */
	@Getter
	@Setter
	private String geoIdTo;
	/**
	 * Geo Id From
	 */
	@Getter
	@Setter
	private String geoIdFrom;
	/**
	 * Weight Break Id
	 */
	@Getter
	@Setter
	private String weightBreakId;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Weight Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal weightUnitPrice;
	/**
	 * Quantity Break Id
	 */
	@Getter
	@Setter
	private String quantityBreakId;
	/**
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;
	/**
	 * Quantity Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal quantityUnitPrice;
	/**
	 * Price Break Id
	 */
	@Getter
	@Setter
	private String priceBreakId;
	/**
	 * Price Uom Id
	 */
	@Getter
	@Setter
	private String priceUomId;
	/**
	 * Price Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal priceUnitPrice;
	/**
	 * Order Flat Price
	 */
	@Getter
	@Setter
	private BigDecimal orderFlatPrice;
	/**
	 * Order Price Percent
	 */
	@Getter
	@Setter
	private BigDecimal orderPricePercent;
	/**
	 * Order Item Flat Price
	 */
	@Getter
	@Setter
	private BigDecimal orderItemFlatPrice;
	/**
	 * Shipping Price Percent
	 */
	@Getter
	@Setter
	private BigDecimal shippingPricePercent;
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
	/**
	 * Oversize Unit
	 */
	@Getter
	@Setter
	private BigDecimal oversizeUnit;
	/**
	 * Oversize Price
	 */
	@Getter
	@Setter
	private BigDecimal oversizePrice;
	/**
	 * Feature Percent
	 */
	@Getter
	@Setter
	private BigDecimal featurePercent;
	/**
	 * Feature Price
	 */
	@Getter
	@Setter
	private BigDecimal featurePrice;
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
		shipmentCostEstimateId, shipmentMethodTypeId, carrierPartyId, carrierRoleTypeId, productStoreShipMethId, productStoreId, partyId, roleTypeId, geoIdTo, geoIdFrom, weightBreakId, weightUomId, weightUnitPrice, quantityBreakId, quantityUomId, quantityUnitPrice, priceBreakId, priceUomId, priceUnitPrice, orderFlatPrice, orderPricePercent, orderItemFlatPrice, shippingPricePercent, productFeatureGroupId, oversizeUnit, oversizePrice, featurePercent, featurePrice, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentCostEstimate(GenericValue value) {
		shipmentCostEstimateId = (String) value
				.get(Fields.shipmentCostEstimateId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		productStoreShipMethId = (String) value
				.get(Fields.productStoreShipMethId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		geoIdTo = (String) value.get(Fields.geoIdTo.name());
		geoIdFrom = (String) value.get(Fields.geoIdFrom.name());
		weightBreakId = (String) value.get(Fields.weightBreakId.name());
		weightUomId = (String) value.get(Fields.weightUomId.name());
		weightUnitPrice = (BigDecimal) value.get(Fields.weightUnitPrice.name());
		quantityBreakId = (String) value.get(Fields.quantityBreakId.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		quantityUnitPrice = (BigDecimal) value.get(Fields.quantityUnitPrice
				.name());
		priceBreakId = (String) value.get(Fields.priceBreakId.name());
		priceUomId = (String) value.get(Fields.priceUomId.name());
		priceUnitPrice = (BigDecimal) value.get(Fields.priceUnitPrice.name());
		orderFlatPrice = (BigDecimal) value.get(Fields.orderFlatPrice.name());
		orderPricePercent = (BigDecimal) value.get(Fields.orderPricePercent
				.name());
		orderItemFlatPrice = (BigDecimal) value.get(Fields.orderItemFlatPrice
				.name());
		shippingPricePercent = (BigDecimal) value
				.get(Fields.shippingPricePercent.name());
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		oversizeUnit = (BigDecimal) value.get(Fields.oversizeUnit.name());
		oversizePrice = (BigDecimal) value.get(Fields.oversizePrice.name());
		featurePercent = (BigDecimal) value.get(Fields.featurePercent.name());
		featurePrice = (BigDecimal) value.get(Fields.featurePrice.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentCostEstimate fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentCostEstimate(value);
	}

	public static List<ShipmentCostEstimate> fromValues(
			List<GenericValue> values) {
		List<ShipmentCostEstimate> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentCostEstimate(value));
		}
		return entities;
	}
}