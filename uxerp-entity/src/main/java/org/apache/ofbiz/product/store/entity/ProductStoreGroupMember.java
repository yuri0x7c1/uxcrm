package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group Member
 */
public class ProductStoreGroupMember implements Serializable {

	public static final long serialVersionUID = 8318789342729052160L;
	public static final String NAME = "ProductStoreGroupMember";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
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
		productStoreId, productStoreGroupId, fromDate, thruDate, sequenceNum
	}

	public ProductStoreGroupMember(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductStoreGroupMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroupMember(value);
	}

	public static List<ProductStoreGroupMember> fromValues(
			List<GenericValue> values) {
		List<ProductStoreGroupMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroupMember(value));
		}
		return entities;
	}
}