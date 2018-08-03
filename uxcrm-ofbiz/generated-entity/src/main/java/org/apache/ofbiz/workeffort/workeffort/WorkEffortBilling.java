package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortBilling implements Serializable {

	public static final long serialVersionUID = 1919676044832851968L;
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

	public enum Fields {
		workEffortId, invoiceId, invoiceItemSeqId, percentage, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortBilling(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		percentage = (Double) value.get(Fields.percentage.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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