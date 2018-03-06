package org.apache.ofbiz.common.theme.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visual Theme Resource
 */
public class VisualThemeResource implements Serializable {

	public static final long serialVersionUID = 7755847025998545920L;
	public static final String NAME = "VisualThemeResource";
	/**
	 * Visual Theme Id
	 */
	@Getter
	@Setter
	private String visualThemeId;
	/**
	 * Resource Type Enum Id
	 */
	@Getter
	@Setter
	private String resourceTypeEnumId;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Resource Value
	 */
	@Getter
	@Setter
	private String resourceValue;

	public enum Fields {
		visualThemeId, resourceTypeEnumId, sequenceId, resourceValue
	}

	public VisualThemeResource(GenericValue value) {
		visualThemeId = (String) value.get(Fields.visualThemeId.name());
		resourceTypeEnumId = (String) value.get(Fields.resourceTypeEnumId
				.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		resourceValue = (String) value.get(Fields.resourceValue.name());
	}

	public static VisualThemeResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VisualThemeResource(value);
	}

	public static List<VisualThemeResource> fromValues(List<GenericValue> values) {
		List<VisualThemeResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VisualThemeResource(value));
		}
		return entities;
	}
}