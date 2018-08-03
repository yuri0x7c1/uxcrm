package org.apache.ofbiz.product.category;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Rollup
 */
public class ProductCategoryRollup implements Serializable {

	public static final long serialVersionUID = 6511903246863095808L;
	public static final String NAME = "ProductCategoryRollup";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Parent Product Category Id
	 */
	@Getter
	@Setter
	private String parentProductCategoryId;
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
		productCategoryId, parentProductCategoryId, fromDate, thruDate, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCategoryRollup(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		parentProductCategoryId = (String) value
				.get(Fields.parentProductCategoryId.name());
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

	public static ProductCategoryRollup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryRollup(value);
	}

	public static List<ProductCategoryRollup> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryRollup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryRollup(value));
		}
		return entities;
	}
}