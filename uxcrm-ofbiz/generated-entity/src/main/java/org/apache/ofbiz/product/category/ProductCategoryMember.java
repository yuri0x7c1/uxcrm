package org.apache.ofbiz.product.category;

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
 * Product Category Member
 */
@FieldNameConstants
public class ProductCategoryMember implements Serializable {

	public static final long serialVersionUID = 1453719829736036352L;
	public static final String NAME = "ProductCategoryMember";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
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

	public ProductCategoryMember(GenericValue value) {
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCategoryMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryMember(value);
	}

	public static List<ProductCategoryMember> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryMember(value));
		}
		return entities;
	}
}