package org.apache.ofbiz.product.store;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductStoreVendorPayment implements Serializable {

	public static final long serialVersionUID = 979829807373044736L;
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

	public ProductStoreVendorPayment(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		vendorPartyId = (String) value.get(FIELD_VENDOR_PARTY_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		creditCardEnumId = (String) value.get(FIELD_CREDIT_CARD_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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