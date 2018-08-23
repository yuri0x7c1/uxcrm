package org.apache.ofbiz.product.cost;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Cost Component Calc
 */
@FieldNameConstants
public class ProductCostComponentCalc implements Serializable {

	public static final long serialVersionUID = 3632193401156647936L;
	public static final String NAME = "ProductCostComponentCalc";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Cost Component Type Id
	 */
	@Getter
	@Setter
	private String costComponentTypeId;
	/**
	 * Cost Component Calc Id
	 */
	@Getter
	@Setter
	private String costComponentCalcId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public ProductCostComponentCalc(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		costComponentTypeId = (String) value.get(FIELD_COST_COMPONENT_TYPE_ID);
		costComponentCalcId = (String) value.get(FIELD_COST_COMPONENT_CALC_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCostComponentCalc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCostComponentCalc(value);
	}

	public static List<ProductCostComponentCalc> fromValues(
			List<GenericValue> values) {
		List<ProductCostComponentCalc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCostComponentCalc(value));
		}
		return entities;
	}
}