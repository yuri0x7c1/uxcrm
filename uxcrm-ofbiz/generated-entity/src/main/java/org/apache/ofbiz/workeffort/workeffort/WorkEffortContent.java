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
 * Work Effort Content
 */
@FieldNameConstants
public class WorkEffortContent implements Serializable {

	public static final long serialVersionUID = 5429657098214241280L;
	public static final String NAME = "WorkEffortContent";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Work Effort Content Type Id
	 */
	@Getter
	@Setter
	private String workEffortContentTypeId;
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

	public WorkEffortContent(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		workEffortContentTypeId = (String) value
				.get(FIELD_WORK_EFFORT_CONTENT_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortContent(value);
	}

	public static List<WorkEffortContent> fromValues(List<GenericValue> values) {
		List<WorkEffortContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortContent(value));
		}
		return entities;
	}
}