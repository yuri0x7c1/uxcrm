package org.apache.ofbiz.product.cost.entity;

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
public class ProductCostComponentCalc implements Serializable {

	public static final long serialVersionUID = 4350950413219926016L;
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

	public enum Fields {
		productId, costComponentTypeId, costComponentCalcId, fromDate, sequenceNum, thruDate
	}

	public ProductCostComponentCalc(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		costComponentTypeId = (String) value.get(Fields.costComponentTypeId
				.name());
		costComponentCalcId = (String) value.get(Fields.costComponentCalcId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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