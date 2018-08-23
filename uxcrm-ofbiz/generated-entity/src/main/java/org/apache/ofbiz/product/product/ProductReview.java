package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductReview implements Serializable {

	public static final long serialVersionUID = 5931876485231823872L;
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

	public ProductReview(GenericValue value) {
		productReviewId = (String) value.get(FIELD_PRODUCT_REVIEW_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		postedAnonymous = (String) value.get(FIELD_POSTED_ANONYMOUS);
		postedDateTime = (Timestamp) value.get(FIELD_POSTED_DATE_TIME);
		productRating = (BigDecimal) value.get(FIELD_PRODUCT_RATING);
		productReview = (String) value.get(FIELD_PRODUCT_REVIEW);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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