package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Vendor Product
 */
@FieldNameConstants
public class VendorProduct implements Serializable {

	public static final long serialVersionUID = 6672804834897677312L;
	public static final String NAME = "VendorProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Vendor Party Id
	 */
	@Getter
	@Setter
	private String vendorPartyId;
	/**
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
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

	public VendorProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		vendorPartyId = (String) value.get(FIELD_VENDOR_PARTY_ID);
		productStoreGroupId = (String) value.get(FIELD_PRODUCT_STORE_GROUP_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static VendorProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VendorProduct(value);
	}

	public static List<VendorProduct> fromValues(List<GenericValue> values) {
		List<VendorProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VendorProduct(value));
		}
		return entities;
	}
}