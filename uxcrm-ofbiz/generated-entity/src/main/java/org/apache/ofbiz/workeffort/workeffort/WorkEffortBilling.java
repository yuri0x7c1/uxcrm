package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Billing
 */
@FieldNameConstants
public class WorkEffortBilling implements Serializable {

	public static final long serialVersionUID = 561397648631995392L;
	public static final String NAME = "WorkEffortBilling";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Percentage
	 */
	@Getter
	@Setter
	private Double percentage;
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

	public WorkEffortBilling(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		percentage = (Double) value.get(FIELD_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortBilling fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortBilling(value);
	}

	public static List<WorkEffortBilling> fromValues(List<GenericValue> values) {
		List<WorkEffortBilling> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortBilling(value));
		}
		return entities;
	}
}