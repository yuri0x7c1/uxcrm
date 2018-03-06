package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group Rollup
 */
public class ProductStoreGroupRollup implements Serializable {

	public static final long serialVersionUID = 4509200460890589184L;
	public static final String NAME = "ProductStoreGroupRollup";
	/**
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
	/**
	 * Parent Group Id
	 */
	@Getter
	@Setter
	private String parentGroupId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		productStoreGroupId, parentGroupId, fromDate, thruDate, sequenceNum
	}

	public ProductStoreGroupRollup(GenericValue value) {
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		parentGroupId = (String) value.get(Fields.parentGroupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductStoreGroupRollup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroupRollup(value);
	}

	public static List<ProductStoreGroupRollup> fromValues(
			List<GenericValue> values) {
		List<ProductStoreGroupRollup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroupRollup(value));
		}
		return entities;
	}
}