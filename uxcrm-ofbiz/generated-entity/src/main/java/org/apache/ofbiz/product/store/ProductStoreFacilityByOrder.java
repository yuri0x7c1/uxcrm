package org.apache.ofbiz.product.store;

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
public class ProductStoreFacilityByOrder implements Serializable {

	public static final long serialVersionUID = 1481036132524878848L;
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

	public enum Fields {
		orderId, productStoreId, facilityId, fromDate, thruDate, sequenceNum, storeName, facilityName, facilityTypeId
	}

	public ProductStoreFacilityByOrder(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		storeName = (String) value.get(Fields.storeName.name());
		facilityName = (String) value.get(Fields.facilityName.name());
		facilityTypeId = (String) value.get(Fields.facilityTypeId.name());
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