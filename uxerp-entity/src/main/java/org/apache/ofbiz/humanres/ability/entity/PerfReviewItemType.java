package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Perf Review Item Type
 */
public class PerfReviewItemType implements Serializable {

	public static final long serialVersionUID = 4027128469067378688L;
	public static final String NAME = "PerfReviewItemType";
	/**
	 * Perf Review Item Type Id
	 */
	@Getter
	@Setter
	private String perfReviewItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		perfReviewItemTypeId, parentTypeId, hasTable, description
	}

	public PerfReviewItemType(GenericValue value) {
		perfReviewItemTypeId = (String) value.get(Fields.perfReviewItemTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PerfReviewItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerfReviewItemType(value);
	}

	public static List<PerfReviewItemType> fromValues(List<GenericValue> values) {
		List<PerfReviewItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerfReviewItemType(value));
		}
		return entities;
	}
}