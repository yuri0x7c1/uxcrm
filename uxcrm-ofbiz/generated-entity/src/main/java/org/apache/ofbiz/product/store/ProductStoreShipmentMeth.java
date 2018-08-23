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
 * Product Store Shipment Meth
 */
@FieldNameConstants
public class ProductStoreShipmentMeth implements Serializable {

	public static final long serialVersionUID = 3711588467343436800L;
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

	public ProductStoreShipmentMeth(GenericValue value) {
		productStoreShipMethId = (String) value
				.get(FIELD_PRODUCT_STORE_SHIP_METH_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		companyPartyId = (String) value.get(FIELD_COMPANY_PARTY_ID);
		minWeight = (BigDecimal) value.get(FIELD_MIN_WEIGHT);
		maxWeight = (BigDecimal) value.get(FIELD_MAX_WEIGHT);
		minSize = (BigDecimal) value.get(FIELD_MIN_SIZE);
		maxSize = (BigDecimal) value.get(FIELD_MAX_SIZE);
		minTotal = (BigDecimal) value.get(FIELD_MIN_TOTAL);
		maxTotal = (BigDecimal) value.get(FIELD_MAX_TOTAL);
		allowUspsAddr = (String) value.get(FIELD_ALLOW_USPS_ADDR);
		requireUspsAddr = (String) value.get(FIELD_REQUIRE_USPS_ADDR);
		allowCompanyAddr = (String) value.get(FIELD_ALLOW_COMPANY_ADDR);
		requireCompanyAddr = (String) value.get(FIELD_REQUIRE_COMPANY_ADDR);
		includeNoChargeItems = (String) value
				.get(FIELD_INCLUDE_NO_CHARGE_ITEMS);
		includeFeatureGroup = (String) value.get(FIELD_INCLUDE_FEATURE_GROUP);
		excludeFeatureGroup = (String) value.get(FIELD_EXCLUDE_FEATURE_GROUP);
		includeGeoId = (String) value.get(FIELD_INCLUDE_GEO_ID);
		excludeGeoId = (String) value.get(FIELD_EXCLUDE_GEO_ID);
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		configProps = (String) value.get(FIELD_CONFIG_PROPS);
		shipmentCustomMethodId = (String) value
				.get(FIELD_SHIPMENT_CUSTOM_METHOD_ID);
		shipmentGatewayConfigId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONFIG_ID);
		sequenceNumber = (Long) value.get(FIELD_SEQUENCE_NUMBER);
		allowancePercent = (BigDecimal) value.get(FIELD_ALLOWANCE_PERCENT);
		minimumPrice = (BigDecimal) value.get(FIELD_MINIMUM_PRICE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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