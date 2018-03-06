package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Search Result
 */
public class WorkEffortSearchResult implements Serializable {

	public static final long serialVersionUID = 6711794520281303040L;
	public static final String NAME = "WorkEffortSearchResult";
	/**
	 * Work Effort Search Result Id
	 */
	@Getter
	@Setter
	private String workEffortSearchResultId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Order By Name
	 */
	@Getter
	@Setter
	private String orderByName;
	/**
	 * Is Ascending
	 */
	@Getter
	@Setter
	private String isAscending;
	/**
	 * Num Results
	 */
	@Getter
	@Setter
	private Long numResults;
	/**
	 * Seconds Total
	 */
	@Getter
	@Setter
	private Double secondsTotal;
	/**
	 * Search Date
	 */
	@Getter
	@Setter
	private Timestamp searchDate;

	public enum Fields {
		workEffortSearchResultId, visitId, orderByName, isAscending, numResults, secondsTotal, searchDate
	}

	public WorkEffortSearchResult(GenericValue value) {
		workEffortSearchResultId = (String) value
				.get(Fields.workEffortSearchResultId.name());
		visitId = (String) value.get(Fields.visitId.name());
		orderByName = (String) value.get(Fields.orderByName.name());
		isAscending = (String) value.get(Fields.isAscending.name());
		numResults = (Long) value.get(Fields.numResults.name());
		secondsTotal = (Double) value.get(Fields.secondsTotal.name());
		searchDate = (Timestamp) value.get(Fields.searchDate.name());
	}

	public static WorkEffortSearchResult fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortSearchResult(value);
	}

	public static List<WorkEffortSearchResult> fromValues(
			List<GenericValue> values) {
		List<WorkEffortSearchResult> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortSearchResult(value));
		}
		return entities;
	}
}