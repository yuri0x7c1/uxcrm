package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Vendor Product
 */
public class VendorProduct implements Serializable {

	public static final long serialVersionUID = 1491397589552940032L;
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

	public enum Fields {
		productId, vendorPartyId, productStoreGroupId
	}

	public VendorProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
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