package org.apache.ofbiz.workeffort.workeffort.entity;

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

	public static final long serialVersionUID = 4477118461289998336L;
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

	public enum Fields {
		workEffortId, contentId, workEffortContentTypeId, fromDate, thruDate
	}

	public WorkEffortContent(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		contentId = (String) value.get(Fields.contentId.name());
		workEffortContentTypeId = (String) value
				.get(Fields.workEffortContentTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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