package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Review
 */
public class ProductReview implements Serializable {

	public static final long serialVersionUID = 4483620433887918080L;
	public static final String NAME = "ProductReview";
	/**
	 * Product Review Id
	 */
	@Getter
	@Setter
	private String productReviewId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Posted Anonymous
	 */
	@Getter
	@Setter
	private String postedAnonymous;
	/**
	 * Posted Date Time
	 */
	@Getter
	@Setter
	private Timestamp postedDateTime;
	/**
	 * Product Rating
	 */
	@Getter
	@Setter
	private BigDecimal productRating;
	/**
	 * Product Review
	 */
	@Getter
	@Setter
	private String productReview;
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
		productReviewId, productStoreId, productId, userLoginId, statusId, postedAnonymous, postedDateTime, productRating, productReview, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductReview(GenericValue value) {
		productReviewId = (String) value.get(Fields.productReviewId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		productId = (String) value.get(Fields.productId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		statusId = (String) value.get(Fields.statusId.name());
		postedAnonymous = (String) value.get(Fields.postedAnonymous.name());
		postedDateTime = (Timestamp) value.get(Fields.postedDateTime.name());
		productRating = (BigDecimal) value.get(Fields.productRating.name());
		productReview = (String) value.get(Fields.productReview.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductReview fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductReview(value);
	}

	public static List<ProductReview> fromValues(List<GenericValue> values) {
		List<ProductReview> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductReview(value));
		}
		return entities;
	}
}