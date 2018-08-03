package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group
 */
public class ProductStoreGroup implements Serializable {

	public static final long serialVersionUID = 2888485930829189120L;
	public static final String NAME = "ProductStoreGroup";
	/**
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
	/**
	 * Product Store Group Type Id
	 */
	@Getter
	@Setter
	private String productStoreGroupTypeId;
	/**
	 * Primary Parent Group Id
	 */
	@Getter
	@Setter
	private String primaryParentGroupId;
	/**
	 * Product Store Group Name
	 */
	@Getter
	@Setter
	private String productStoreGroupName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		productStoreGroupId, productStoreGroupTypeId, primaryParentGroupId, productStoreGroupName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreGroup(GenericValue value) {
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		productStoreGroupTypeId = (String) value
				.get(Fields.productStoreGroupTypeId.name());
		primaryParentGroupId = (String) value.get(Fields.primaryParentGroupId
				.name());
		productStoreGroupName = (String) value.get(Fields.productStoreGroupName
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductStoreGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroup(value);
	}

	public static List<ProductStoreGroup> fromValues(List<GenericValue> values) {
		List<ProductStoreGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroup(value));
		}
		return entities;
	}
}