package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group Role
 */
public class ProductStoreGroupRole implements Serializable {

	public static final long serialVersionUID = 6918896365386329088L;
	public static final String NAME = "ProductStoreGroupRole";
	/**
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
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

	public enum Fields {
		productStoreGroupId, partyId, roleTypeId
	}

	public ProductStoreGroupRole(GenericValue value) {
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static ProductStoreGroupRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroupRole(value);
	}

	public static List<ProductStoreGroupRole> fromValues(
			List<GenericValue> values) {
		List<ProductStoreGroupRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroupRole(value));
		}
		return entities;
	}
}