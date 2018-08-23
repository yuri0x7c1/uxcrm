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
 * Product Assoc
 */
@FieldNameConstants
public class ProductAssoc implements Serializable {

	public static final long serialVersionUID = 2380598794069606400L;
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

	public ProductAssoc(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productIdTo = (String) value.get(FIELD_PRODUCT_ID_TO);
		productAssocTypeId = (String) value.get(FIELD_PRODUCT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		reason = (String) value.get(FIELD_REASON);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		scrapFactor = (BigDecimal) value.get(FIELD_SCRAP_FACTOR);
		instruction = (String) value.get(FIELD_INSTRUCTION);
		routingWorkEffortId = (String) value.get(FIELD_ROUTING_WORK_EFFORT_ID);
		estimateCalcMethod = (String) value.get(FIELD_ESTIMATE_CALC_METHOD);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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