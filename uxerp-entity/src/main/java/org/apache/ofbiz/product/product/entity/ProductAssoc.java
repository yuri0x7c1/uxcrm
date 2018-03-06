package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Assoc
 */
public class ProductAssoc implements Serializable {

	public static final long serialVersionUID = 1290149771596796928L;
	public static final String NAME = "ProductAssoc";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Id To
	 */
	@Getter
	@Setter
	private String productIdTo;
	/**
	 * Product Assoc Type Id
	 */
	@Getter
	@Setter
	private String productAssocTypeId;
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
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Scrap Factor
	 */
	@Getter
	@Setter
	private BigDecimal scrapFactor;
	/**
	 * Instruction
	 */
	@Getter
	@Setter
	private String instruction;
	/**
	 * Routing Work Effort Id
	 */
	@Getter
	@Setter
	private String routingWorkEffortId;
	/**
	 * Estimate Calc Method
	 */
	@Getter
	@Setter
	private String estimateCalcMethod;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;

	public enum Fields {
		productId, productIdTo, productAssocTypeId, fromDate, thruDate, sequenceNum, reason, quantity, scrapFactor, instruction, routingWorkEffortId, estimateCalcMethod, recurrenceInfoId
	}

	public ProductAssoc(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productIdTo = (String) value.get(Fields.productIdTo.name());
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		reason = (String) value.get(Fields.reason.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		scrapFactor = (BigDecimal) value.get(Fields.scrapFactor.name());
		instruction = (String) value.get(Fields.instruction.name());
		routingWorkEffortId = (String) value.get(Fields.routingWorkEffortId
				.name());
		estimateCalcMethod = (String) value.get(Fields.estimateCalcMethod
				.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
	}

	public static ProductAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAssoc(value);
	}

	public static List<ProductAssoc> fromValues(List<GenericValue> values) {
		List<ProductAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAssoc(value));
		}
		return entities;
	}
}