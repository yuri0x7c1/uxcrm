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
 * Shipment Cost Estimate
 */
@FieldNameConstants
public class ShipmentCostEstimate implements Serializable {

	public static final long serialVersionUID = 4814167936380244992L;
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

	public ShipmentCostEstimate(GenericValue value) {
		shipmentCostEstimateId = (String) value
				.get(FIELD_SHIPMENT_COST_ESTIMATE_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		productStoreShipMethId = (String) value
				.get(FIELD_PRODUCT_STORE_SHIP_METH_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		geoIdTo = (String) value.get(FIELD_GEO_ID_TO);
		geoIdFrom = (String) value.get(FIELD_GEO_ID_FROM);
		weightBreakId = (String) value.get(FIELD_WEIGHT_BREAK_ID);
		weightUomId = (String) value.get(FIELD_WEIGHT_UOM_ID);
		weightUnitPrice = (BigDecimal) value.get(FIELD_WEIGHT_UNIT_PRICE);
		quantityBreakId = (String) value.get(FIELD_QUANTITY_BREAK_ID);
		quantityUomId = (String) value.get(FIELD_QUANTITY_UOM_ID);
		quantityUnitPrice = (BigDecimal) value.get(FIELD_QUANTITY_UNIT_PRICE);
		priceBreakId = (String) value.get(FIELD_PRICE_BREAK_ID);
		priceUomId = (String) value.get(FIELD_PRICE_UOM_ID);
		priceUnitPrice = (BigDecimal) value.get(FIELD_PRICE_UNIT_PRICE);
		orderFlatPrice = (BigDecimal) value.get(FIELD_ORDER_FLAT_PRICE);
		orderPricePercent = (BigDecimal) value.get(FIELD_ORDER_PRICE_PERCENT);
		orderItemFlatPrice = (BigDecimal) value
				.get(FIELD_ORDER_ITEM_FLAT_PRICE);
		shippingPricePercent = (BigDecimal) value
				.get(FIELD_SHIPPING_PRICE_PERCENT);
		productFeatureGroupId = (String) value
				.get(FIELD_PRODUCT_FEATURE_GROUP_ID);
		oversizeUnit = (BigDecimal) value.get(FIELD_OVERSIZE_UNIT);
		oversizePrice = (BigDecimal) value.get(FIELD_OVERSIZE_PRICE);
		featurePercent = (BigDecimal) value.get(FIELD_FEATURE_PERCENT);
		featurePrice = (BigDecimal) value.get(FIELD_FEATURE_PRICE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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