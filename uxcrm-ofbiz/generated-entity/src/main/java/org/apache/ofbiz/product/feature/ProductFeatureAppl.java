package org.apache.ofbiz.product.feature;

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
 * Product Feature Appl
 */
@FieldNameConstants
public class ProductFeatureAppl implements Serializable {

	public static final long serialVersionUID = 1776550384549173248L;
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

	public ProductFeatureAppl(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		productFeatureApplTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_APPL_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		recurringAmount = (BigDecimal) value.get(FIELD_RECURRING_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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