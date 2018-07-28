package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Vendor Payment
 */
public class ProductStoreVendorPayment implements Serializable {

	public static final long serialVersionUID = 5862717419819077632L;
	public static final String NAME = "ProductStoreVendorPayment";
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
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Credit Card Enum Id
	 */
	@Getter
	@Setter
	private String creditCardEnumId;
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
		productStoreId, vendorPartyId, paymentMethodTypeId, creditCardEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreVendorPayment(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		creditCardEnumId = (String) value.get(Fields.creditCardEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStoreVendorPayment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreVendorPayment(value);
	}

	public static List<ProductStoreVendorPayment> fromValues(
			List<GenericValue> values) {
		List<ProductStoreVendorPayment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreVendorPayment(value));
		}
		return entities;
	}
}