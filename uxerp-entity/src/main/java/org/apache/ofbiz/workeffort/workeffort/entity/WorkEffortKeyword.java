package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Keyword
 */
public class WorkEffortKeyword implements Serializable {

	public static final long serialVersionUID = 1041486131733870592L;
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

	public enum Fields {
		workEffortId, keyword, relevancyWeight
	}

	public WorkEffortKeyword(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		keyword = (String) value.get(Fields.keyword.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
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