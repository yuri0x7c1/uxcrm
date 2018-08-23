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
 * Product Store Facility By Order
 */
@FieldNameConstants
public class ProductStoreFacilityByOrder implements Serializable {

	public static final long serialVersionUID = 8200337283864923136L;
	public static final String NAME = "ProductStoreFacilityByOrder";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
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
	/**
	 * Store Name
	 */
	@Getter
	@Setter
	private String storeName;
	/**
	 * Facility Name
	 */
	@Getter
	@Setter
	private String facilityName;
	/**
	 * Facility Type Id
	 */
	@Getter
	@Setter
	private String facilityTypeId;

	public ProductStoreFacilityByOrder(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		storeName = (String) value.get(FIELD_STORE_NAME);
		facilityName = (String) value.get(FIELD_FACILITY_NAME);
		facilityTypeId = (String) value.get(FIELD_FACILITY_TYPE_ID);
	}

	public static ProductStoreFacilityByOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreFacilityByOrder(value);
	}

	public static List<ProductStoreFacilityByOrder> fromValues(
			List<GenericValue> values) {
		List<ProductStoreFacilityByOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreFacilityByOrder(value));
		}
		return entities;
	}
}