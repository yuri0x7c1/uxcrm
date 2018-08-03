package org.apache.ofbiz.product.store;

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

	public static final long serialVersionUID = 3229972227747618816L;
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
		productStoreGroupId, parentGroupId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStoreGroupRollup(GenericValue value) {
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		parentGroupId = (String) value.get(Fields.parentGroupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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