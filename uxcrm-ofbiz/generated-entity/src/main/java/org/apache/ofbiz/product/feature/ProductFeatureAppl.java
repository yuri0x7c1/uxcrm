package org.apache.ofbiz.product.feature;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Appl
 */
public class ProductFeatureAppl implements Serializable {

	public static final long serialVersionUID = 8054096671531987968L;
	public static final String NAME = "ProductFeatureAppl";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Product Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String productFeatureApplTypeId;
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
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Recurring Amount
	 */
	@Getter
	@Setter
	private BigDecimal recurringAmount;
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
		productId, productFeatureId, productFeatureApplTypeId, fromDate, thruDate, sequenceNum, amount, recurringAmount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureAppl(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		recurringAmount = (BigDecimal) value.get(Fields.recurringAmount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFeatureAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureAppl(value);
	}

	public static List<ProductFeatureAppl> fromValues(List<GenericValue> values) {
		List<ProductFeatureAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureAppl(value));
		}
		return entities;
	}
}