package org.apache.ofbiz.manufacturing.bom;

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
public class ProductManufacturingRule implements Serializable {

	public static final long serialVersionUID = 4028517720313143296L;
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

	public enum Fields {
		ruleId, productId, productIdFor, productIdIn, ruleSeqId, fromDate, productIdInSubst, productFeature, ruleOperator, quantity, description, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductManufacturingRule(GenericValue value) {
		ruleId = (String) value.get(Fields.ruleId.name());
		productId = (String) value.get(Fields.productId.name());
		productIdFor = (String) value.get(Fields.productIdFor.name());
		productIdIn = (String) value.get(Fields.productIdIn.name());
		ruleSeqId = (String) value.get(Fields.ruleSeqId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		productIdInSubst = (String) value.get(Fields.productIdInSubst.name());
		productFeature = (String) value.get(Fields.productFeature.name());
		ruleOperator = (String) value.get(Fields.ruleOperator.name());
		quantity = (Double) value.get(Fields.quantity.name());
		description = (String) value.get(Fields.description.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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