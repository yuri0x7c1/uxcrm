package org.apache.ofbiz.manufacturing.bom;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Manufacturing Rule
 */
@FieldNameConstants
public class ProductManufacturingRule implements Serializable {

	public static final long serialVersionUID = 2622565405100555264L;
	public static final String NAME = "ProductManufacturingRule";
	/**
	 * Rule Id
	 */
	@Getter
	@Setter
	private String ruleId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Id For
	 */
	@Getter
	@Setter
	private String productIdFor;
	/**
	 * Product Id In
	 */
	@Getter
	@Setter
	private String productIdIn;
	/**
	 * Rule Seq Id
	 */
	@Getter
	@Setter
	private String ruleSeqId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Product Id In Subst
	 */
	@Getter
	@Setter
	private String productIdInSubst;
	/**
	 * Product Feature
	 */
	@Getter
	@Setter
	private String productFeature;
	/**
	 * Rule Operator
	 */
	@Getter
	@Setter
	private String ruleOperator;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private Double quantity;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public ProductManufacturingRule(GenericValue value) {
		ruleId = (String) value.get(FIELD_RULE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productIdFor = (String) value.get(FIELD_PRODUCT_ID_FOR);
		productIdIn = (String) value.get(FIELD_PRODUCT_ID_IN);
		ruleSeqId = (String) value.get(FIELD_RULE_SEQ_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		productIdInSubst = (String) value.get(FIELD_PRODUCT_ID_IN_SUBST);
		productFeature = (String) value.get(FIELD_PRODUCT_FEATURE);
		ruleOperator = (String) value.get(FIELD_RULE_OPERATOR);
		quantity = (Double) value.get(FIELD_QUANTITY);
		description = (String) value.get(FIELD_DESCRIPTION);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductManufacturingRule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductManufacturingRule(value);
	}

	public static List<ProductManufacturingRule> fromValues(
			List<GenericValue> values) {
		List<ProductManufacturingRule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductManufacturingRule(value));
		}
		return entities;
	}
}