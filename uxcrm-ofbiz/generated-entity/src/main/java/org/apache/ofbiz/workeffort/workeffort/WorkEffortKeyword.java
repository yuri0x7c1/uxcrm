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
 * Work Effort Keyword
 */
@FieldNameConstants
public class WorkEffortKeyword implements Serializable {

	public static final long serialVersionUID = 3402774442780537856L;
	public static final String NAME = "WorkEffortKeyword";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
	/**
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;
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

	public WorkEffortKeyword(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		keyword = (String) value.get(FIELD_KEYWORD);
		relevancyWeight = (Long) value.get(FIELD_RELEVANCY_WEIGHT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortKeyword(value);
	}

	public static List<WorkEffortKeyword> fromValues(List<GenericValue> values) {
		List<WorkEffortKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortKeyword(value));
		}
		return entities;
	}
}