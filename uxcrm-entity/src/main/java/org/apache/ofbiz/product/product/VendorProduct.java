package org.apache.ofbiz.product.product;

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
public class VendorProduct implements Serializable {

	public static final long serialVersionUID = 5314280066089804800L;
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

	public enum Fields {
		productId, vendorPartyId, productStoreGroupId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public VendorProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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