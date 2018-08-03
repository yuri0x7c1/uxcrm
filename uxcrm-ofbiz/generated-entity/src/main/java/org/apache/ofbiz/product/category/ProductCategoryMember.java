package org.apache.ofbiz.product.category;

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
public class ProductCategoryMember implements Serializable {

	public static final long serialVersionUID = 6462257277949370368L;
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

	public enum Fields {
		productCategoryId, productId, fromDate, thruDate, comments, sequenceNum, quantity, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductCategoryMember(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		productId = (String) value.get(Fields.productId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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