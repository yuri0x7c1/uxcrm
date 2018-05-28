package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortKeyword implements Serializable {

	public static final long serialVersionUID = 8033339731718111232L;
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

	public enum Fields {
		workEffortId, keyword, relevancyWeight, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortKeyword(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		keyword = (String) value.get(Fields.keyword.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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