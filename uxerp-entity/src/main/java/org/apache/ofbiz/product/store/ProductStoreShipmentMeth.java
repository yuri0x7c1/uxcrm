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
 * Product Store Shipment Meth
 */
public class ProductStoreShipmentMeth implements Serializable {

	public static final long serialVersionUID = 753387412635247616L;
	public static final String NAME = "ProductStoreShipmentMeth";
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
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
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
	 * Company Party Id
	 */
	@Getter
	@Setter
	private String companyPartyId;
	/**
	 * Min Weight
	 */
	@Getter
	@Setter
	private BigDecimal minWeight;
	/**
	 * Max Weight
	 */
	@Getter
	@Setter
	private BigDecimal maxWeight;
	/**
	 * Min Size
	 */
	@Getter
	@Setter
	private BigDecimal minSize;
	/**
	 * Max Size
	 */
	@Getter
	@Setter
	private BigDecimal maxSize;
	/**
	 * Min Total
	 */
	@Getter
	@Setter
	private BigDecimal minTotal;
	/**
	 * Max Total
	 */
	@Getter
	@Setter
	private BigDecimal maxTotal;
	/**
	 * Allow Usps Addr
	 */
	@Getter
	@Setter
	private String allowUspsAddr;
	/**
	 * Require Usps Addr
	 */
	@Getter
	@Setter
	private String requireUspsAddr;
	/**
	 * Allow Company Addr
	 */
	@Getter
	@Setter
	private String allowCompanyAddr;
	/**
	 * Require Company Addr
	 */
	@Getter
	@Setter
	private String requireCompanyAddr;
	/**
	 * Include No Charge Items
	 */
	@Getter
	@Setter
	private String includeNoChargeItems;
	/**
	 * Include Feature Group
	 */
	@Getter
	@Setter
	private String includeFeatureGroup;
	/**
	 * Exclude Feature Group
	 */
	@Getter
	@Setter
	private String excludeFeatureGroup;
	/**
	 * Include Geo Id
	 */
	@Getter
	@Setter
	private String includeGeoId;
	/**
	 * Exclude Geo Id
	 */
	@Getter
	@Setter
	private String excludeGeoId;
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Config Props
	 */
	@Getter
	@Setter
	private String configProps;
	/**
	 * Shipment Custom Method Id
	 */
	@Getter
	@Setter
	private String shipmentCustomMethodId;
	/**
	 * Shipment Gateway Config Id
	 */
	@Getter
	@Setter
	private String shipmentGatewayConfigId;
	/**
	 * Sequence Number
	 */
	@Getter
	@Setter
	private Long sequenceNumber;
	/**
	 * Allowance Percent
	 */
	@Getter
	@Setter
	private BigDecimal allowancePercent;
	/**
	 * Minimum Price
	 */
	@Getter
	@Setter
	private BigDecimal minimumPrice;
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
		productStoreShipMethId, productStoreId, shipmentMethodTypeId, partyId, roleTypeId, companyPartyId, minWeight, maxWeight, minSize, maxSize, minTotal, maxTotal, allowUspsAddr, requireUspsAddr, allowCompanyAddr, requireCompanyAddr, includeNoChargeItems, includeFeatureGroup, excludeFeatureGroup, includeGeoId, excludeGeoId, serviceName, configProps, shipmentCustomMethodId, shipmentGatewayConfigId, sequenceNumber, allowancePercent, minimumPrice, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreShipmentMeth(GenericValue value) {
		productStoreShipMethId = (String) value
				.get(Fields.productStoreShipMethId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		companyPartyId = (String) value.get(Fields.companyPartyId.name());
		minWeight = (BigDecimal) value.get(Fields.minWeight.name());
		maxWeight = (BigDecimal) value.get(Fields.maxWeight.name());
		minSize = (BigDecimal) value.get(Fields.minSize.name());
		maxSize = (BigDecimal) value.get(Fields.maxSize.name());
		minTotal = (BigDecimal) value.get(Fields.minTotal.name());
		maxTotal = (BigDecimal) value.get(Fields.maxTotal.name());
		allowUspsAddr = (String) value.get(Fields.allowUspsAddr.name());
		requireUspsAddr = (String) value.get(Fields.requireUspsAddr.name());
		allowCompanyAddr = (String) value.get(Fields.allowCompanyAddr.name());
		requireCompanyAddr = (String) value.get(Fields.requireCompanyAddr
				.name());
		includeNoChargeItems = (String) value.get(Fields.includeNoChargeItems
				.name());
		includeFeatureGroup = (String) value.get(Fields.includeFeatureGroup
				.name());
		excludeFeatureGroup = (String) value.get(Fields.excludeFeatureGroup
				.name());
		includeGeoId = (String) value.get(Fields.includeGeoId.name());
		excludeGeoId = (String) value.get(Fields.excludeGeoId.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		configProps = (String) value.get(Fields.configProps.name());
		shipmentCustomMethodId = (String) value
				.get(Fields.shipmentCustomMethodId.name());
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		sequenceNumber = (Long) value.get(Fields.sequenceNumber.name());
		allowancePercent = (BigDecimal) value.get(Fields.allowancePercent
				.name());
		minimumPrice = (BigDecimal) value.get(Fields.minimumPrice.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStoreShipmentMeth fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreShipmentMeth(value);
	}

	public static List<ProductStoreShipmentMeth> fromValues(
			List<GenericValue> values) {
		List<ProductStoreShipmentMeth> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreShipmentMeth(value));
		}
		return entities;
	}
}