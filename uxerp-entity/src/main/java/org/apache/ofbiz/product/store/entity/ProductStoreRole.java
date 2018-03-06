package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Role
 */
public class ProductStoreRole implements Serializable {

	public static final long serialVersionUID = 6710154368784384L;
	public static final String NAME = "ProductStoreRole";
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
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
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
		partyId, roleTypeId, productStoreId, fromDate, thruDate, sequenceNum
	}

	public ProductStoreRole(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductStoreRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreRole(value);
	}

	public static List<ProductStoreRole> fromValues(List<GenericValue> values) {
		List<ProductStoreRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreRole(value));
		}
		return entities;
	}
}