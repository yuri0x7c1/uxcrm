package org.apache.ofbiz.common.theme.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visual Theme Set
 */
public class VisualThemeSet implements Serializable {

	public static final long serialVersionUID = 5590999091546446848L;
	public static final String NAME = "VisualThemeSet";
	/**
	 * Visual Theme Set Id
	 */
	@Getter
	@Setter
	private String visualThemeSetId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		visualThemeSetId, description
	}

	public VisualThemeSet(GenericValue value) {
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static VisualThemeSet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VisualThemeSet(value);
	}

	public static List<VisualThemeSet> fromValues(List<GenericValue> values) {
		List<VisualThemeSet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VisualThemeSet(value));
		}
		return entities;
	}
}