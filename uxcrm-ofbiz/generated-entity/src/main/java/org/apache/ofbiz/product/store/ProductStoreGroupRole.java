package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group Role
 */
public class ProductStoreGroupRole implements Serializable {

	public static final long serialVersionUID = 6715202178893066240L;
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
		productStoreGroupId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreGroupRole(GenericValue value) {
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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