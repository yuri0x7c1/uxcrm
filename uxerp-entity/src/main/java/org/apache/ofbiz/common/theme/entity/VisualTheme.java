package org.apache.ofbiz.common.theme.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visual Theme
 */
public class VisualTheme implements Serializable {

	public static final long serialVersionUID = 6032975334637244416L;
	public static final String NAME = "VisualTheme";
	/**
	 * Visual Theme Id
	 */
	@Getter
	@Setter
	private String visualThemeId;
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
		visualThemeId, visualThemeSetId, description
	}

	public VisualTheme(GenericValue value) {
		visualThemeId = (String) value.get(Fields.visualThemeId.name());
		visualThemeSetId = (String) value.get(Fields.visualThemeSetId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static VisualTheme fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VisualTheme(value);
	}

	public static List<VisualTheme> fromValues(List<GenericValue> values) {
		List<VisualTheme> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VisualTheme(value));
		}
		return entities;
	}
}