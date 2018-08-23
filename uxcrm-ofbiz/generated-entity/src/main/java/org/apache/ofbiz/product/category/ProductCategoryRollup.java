package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductCategoryRollup implements Serializable {

	public static final long serialVersionUID = 4977174051899401216L;
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

	public ProductCategoryRollup(GenericValue value) {
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		parentProductCategoryId = (String) value
				.get(FIELD_PARENT_PRODUCT_CATEGORY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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