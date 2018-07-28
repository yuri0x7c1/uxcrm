package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortContent implements Serializable {

	public static final long serialVersionUID = 7774957932694313984L;
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

	public enum Fields {
		workEffortId, contentId, workEffortContentTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortContent(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		contentId = (String) value.get(Fields.contentId.name());
		workEffortContentTypeId = (String) value
				.get(Fields.workEffortContentTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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