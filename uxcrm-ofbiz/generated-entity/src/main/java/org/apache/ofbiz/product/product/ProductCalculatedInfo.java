package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Calculated Info
 */
@FieldNameConstants
public class ProductCalculatedInfo implements Serializable {

	public static final long serialVersionUID = 3575280089612226560L;
	public static final String NAME = "ProductCalculatedInfo";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Total Quantity Ordered
	 */
	@Getter
	@Setter
	private BigDecimal totalQuantityOrdered;
	/**
	 * Total Times Viewed
	 */
	@Getter
	@Setter
	private Long totalTimesViewed;
	/**
	 * Average Customer Rating
	 */
	@Getter
	@Setter
	private BigDecimal averageCustomerRating;
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

	public ProductCalculatedInfo(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		totalQuantityOrdered = (BigDecimal) value
				.get(FIELD_TOTAL_QUANTITY_ORDERED);
		totalTimesViewed = (Long) value.get(FIELD_TOTAL_TIMES_VIEWED);
		averageCustomerRating = (BigDecimal) value
				.get(FIELD_AVERAGE_CUSTOMER_RATING);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCalculatedInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCalculatedInfo(value);
	}

	public static List<ProductCalculatedInfo> fromValues(
			List<GenericValue> values) {
		List<ProductCalculatedInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCalculatedInfo(value));
		}
		return entities;
	}
}