package org.apache.ofbiz.product.product;

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
public class ProductCalculatedInfo implements Serializable {

	public static final long serialVersionUID = 2066981253940258816L;
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

	public enum Fields {
		productId, totalQuantityOrdered, totalTimesViewed, averageCustomerRating, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCalculatedInfo(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		totalQuantityOrdered = (BigDecimal) value
				.get(Fields.totalQuantityOrdered.name());
		totalTimesViewed = (Long) value.get(Fields.totalTimesViewed.name());
		averageCustomerRating = (BigDecimal) value
				.get(Fields.averageCustomerRating.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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