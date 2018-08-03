package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Vendor Shipment
 */
public class ProductStoreVendorShipment implements Serializable {

	public static final long serialVersionUID = 8890358810979589120L;
	public static final String NAME = "ProductStoreVendorShipment";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Vendor Party Id
	 */
	@Getter
	@Setter
	private String vendorPartyId;
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
		productStoreId, vendorPartyId, shipmentMethodTypeId, carrierPartyId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreVendorShipment(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStoreVendorShipment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreVendorShipment(value);
	}

	public static List<ProductStoreVendorShipment> fromValues(
			List<GenericValue> values) {
		List<ProductStoreVendorShipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreVendorShipment(value));
		}
		return entities;
	}
}