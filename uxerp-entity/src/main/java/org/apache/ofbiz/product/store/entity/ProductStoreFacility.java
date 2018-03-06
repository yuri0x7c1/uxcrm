package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Facility
 */
public class ProductStoreFacility implements Serializable {

	public static final long serialVersionUID = 7070445770943527936L;
	public static final String NAME = "ProductStoreFacility";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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
		productStoreId, facilityId, fromDate, thruDate, sequenceNum
	}

	public ProductStoreFacility(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductStoreFacility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreFacility(value);
	}

	public static List<ProductStoreFacility> fromValues(
			List<GenericValue> values) {
		List<ProductStoreFacility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreFacility(value));
		}
		return entities;
	}
}