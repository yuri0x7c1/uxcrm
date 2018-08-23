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
 * Work Effort Assoc
 */
@FieldNameConstants
public class WorkEffortAssoc implements Serializable {

	public static final long serialVersionUID = 1288737818157222912L;
	public static final String NAME = "WorkEffortAssoc";
	/**
	 * Work Effort Id From
	 */
	@Getter
	@Setter
	private String workEffortIdFrom;
	/**
	 * Work Effort Id To
	 */
	@Getter
	@Setter
	private String workEffortIdTo;
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public WorkEffortAssoc(GenericValue value) {
		workEffortIdFrom = (String) value.get(FIELD_WORK_EFFORT_ID_FROM);
		workEffortIdTo = (String) value.get(FIELD_WORK_EFFORT_ID_TO);
		workEffortAssocTypeId = (String) value
				.get(FIELD_WORK_EFFORT_ASSOC_TYPE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssoc(value);
	}

	public static List<WorkEffortAssoc> fromValues(List<GenericValue> values) {
		List<WorkEffortAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssoc(value));
		}
		return entities;
	}
}