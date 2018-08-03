package org.apache.ofbiz.product.store;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group Rollup And Child
 */
public class ProductStoreGroupRollupAndChild implements Serializable {

	public static final long serialVersionUID = 1425541386422625280L;
	public static final String NAME = "ProductStoreGroupRollupAndChild";
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
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Parent Group Id
	 */
	@Getter
	@Setter
	private String parentGroupId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		productStoreGroupTypeId, primaryParentGroupId, productStoreGroupName, description, productStoreGroupId, fromDate, sequenceNum, parentGroupId, thruDate
	}

	public ProductStoreGroupRollupAndChild(GenericValue value) {
		productStoreGroupTypeId = (String) value
				.get(Fields.productStoreGroupTypeId.name());
		primaryParentGroupId = (String) value.get(Fields.primaryParentGroupId
				.name());
		productStoreGroupName = (String) value.get(Fields.productStoreGroupName
				.name());
		description = (String) value.get(Fields.description.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		parentGroupId = (String) value.get(Fields.parentGroupId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ProductStoreGroupRollupAndChild fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroupRollupAndChild(value);
	}

	public static List<ProductStoreGroupRollupAndChild> fromValues(
			List<GenericValue> values) {
		List<ProductStoreGroupRollupAndChild> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroupRollupAndChild(value));
		}
		return entities;
	}
}