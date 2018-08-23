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
 * Work Effort Search Result
 */
@FieldNameConstants
public class WorkEffortSearchResult implements Serializable {

	public static final long serialVersionUID = 2324420746787172352L;
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

	public WorkEffortSearchResult(GenericValue value) {
		workEffortSearchResultId = (String) value
				.get(FIELD_WORK_EFFORT_SEARCH_RESULT_ID);
		visitId = (String) value.get(FIELD_VISIT_ID);
		orderByName = (String) value.get(FIELD_ORDER_BY_NAME);
		isAscending = (String) value.get(FIELD_IS_ASCENDING);
		numResults = (Long) value.get(FIELD_NUM_RESULTS);
		secondsTotal = (Double) value.get(FIELD_SECONDS_TOTAL);
		searchDate = (Timestamp) value.get(FIELD_SEARCH_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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