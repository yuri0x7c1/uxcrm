package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Perf Rating Type
 */
public class PerfRatingType implements Serializable {

	public static final long serialVersionUID = 6035733350545554432L;
	public static final String NAME = "PerfRatingType";
	/**
	 * Perf Rating Type Id
	 */
	@Getter
	@Setter
	private String perfRatingTypeId;
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
		perfRatingTypeId, parentTypeId, hasTable, description
	}

	public PerfRatingType(GenericValue value) {
		perfRatingTypeId = (String) value.get(Fields.perfRatingTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PerfRatingType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerfRatingType(value);
	}

	public static List<PerfRatingType> fromValues(List<GenericValue> values) {
		List<PerfRatingType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerfRatingType(value));
		}
		return entities;
	}
}