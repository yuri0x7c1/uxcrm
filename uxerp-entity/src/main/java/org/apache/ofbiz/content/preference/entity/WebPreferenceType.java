package org.apache.ofbiz.content.preference.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Preference Type
 */
public class WebPreferenceType implements Serializable {

	public static final long serialVersionUID = 1062593923671669760L;
	public static final String NAME = "WebPreferenceType";
	/**
	 * Web Preference Type Id
	 */
	@Getter
	@Setter
	private String webPreferenceTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		webPreferenceTypeId, description
	}

	public WebPreferenceType(GenericValue value) {
		webPreferenceTypeId = (String) value.get(Fields.webPreferenceTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WebPreferenceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebPreferenceType(value);
	}

	public static List<WebPreferenceType> fromValues(List<GenericValue> values) {
		List<WebPreferenceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebPreferenceType(value));
		}
		return entities;
	}
}