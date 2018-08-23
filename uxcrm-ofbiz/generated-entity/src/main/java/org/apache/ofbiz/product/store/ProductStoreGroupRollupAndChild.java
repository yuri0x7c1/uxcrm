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
 * Product Store Group Rollup And Child
 */
@FieldNameConstants
public class ProductStoreGroupRollupAndChild implements Serializable {

	public static final long serialVersionUID = 8532247616310163456L;
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

	public ProductStoreGroupRollupAndChild(GenericValue value) {
		productStoreGroupTypeId = (String) value
				.get(FIELD_PRODUCT_STORE_GROUP_TYPE_ID);
		primaryParentGroupId = (String) value
				.get(FIELD_PRIMARY_PARENT_GROUP_ID);
		productStoreGroupName = (String) value
				.get(FIELD_PRODUCT_STORE_GROUP_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		productStoreGroupId = (String) value.get(FIELD_PRODUCT_STORE_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		parentGroupId = (String) value.get(FIELD_PARENT_GROUP_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
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