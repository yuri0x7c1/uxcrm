package org.apache.ofbiz.product.store.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Shipment Meth View
 */
public class ProductStoreShipmentMethView implements Serializable {

	public static final long serialVersionUID = 7324430238216983552L;
	public static final String NAME = "ProductStoreShipmentMethView";
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productStoreShipMethId, productStoreId, shipmentMethodTypeId, partyId, roleTypeId, companyPartyId, minSize, maxSize, minTotal, maxTotal, minWeight, maxWeight, allowUspsAddr, requireUspsAddr, allowCompanyAddr, requireCompanyAddr, includeNoChargeItems, includeGeoId, excludeGeoId, includeFeatureGroup, excludeFeatureGroup, serviceName, configProps, shipmentCustomMethodId, shipmentGatewayConfigId, sequenceNumber, description
	}

	public ProductStoreShipmentMethView(GenericValue value) {
		productStoreShipMethId = (String) value
				.get(Fields.productStoreShipMethId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		companyPartyId = (String) value.get(Fields.companyPartyId.name());
		minSize = (BigDecimal) value.get(Fields.minSize.name());
		maxSize = (BigDecimal) value.get(Fields.maxSize.name());
		minTotal = (BigDecimal) value.get(Fields.minTotal.name());
		maxTotal = (BigDecimal) value.get(Fields.maxTotal.name());
		minWeight = (BigDecimal) value.get(Fields.minWeight.name());
		maxWeight = (BigDecimal) value.get(Fields.maxWeight.name());
		allowUspsAddr = (String) value.get(Fields.allowUspsAddr.name());
		requireUspsAddr = (String) value.get(Fields.requireUspsAddr.name());
		allowCompanyAddr = (String) value.get(Fields.allowCompanyAddr.name());
		requireCompanyAddr = (String) value.get(Fields.requireCompanyAddr
				.name());
		includeNoChargeItems = (String) value.get(Fields.includeNoChargeItems
				.name());
		includeGeoId = (String) value.get(Fields.includeGeoId.name());
		excludeGeoId = (String) value.get(Fields.excludeGeoId.name());
		includeFeatureGroup = (String) value.get(Fields.includeFeatureGroup
				.name());
		excludeFeatureGroup = (String) value.get(Fields.excludeFeatureGroup
				.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		configProps = (String) value.get(Fields.configProps.name());
		shipmentCustomMethodId = (String) value
				.get(Fields.shipmentCustomMethodId.name());
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		sequenceNumber = (Long) value.get(Fields.sequenceNumber.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductStoreShipmentMethView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreShipmentMethView(value);
	}

	public static List<ProductStoreShipmentMethView> fromValues(
			List<GenericValue> values) {
		List<ProductStoreShipmentMethView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreShipmentMethView(value));
		}
		return entities;
	}
}