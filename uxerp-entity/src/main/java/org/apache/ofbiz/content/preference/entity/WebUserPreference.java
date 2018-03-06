package org.apache.ofbiz.content.preference.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web User Preference
 */
public class WebUserPreference implements Serializable {

	public static final long serialVersionUID = 5564218107243240448L;
	public static final String NAME = "WebUserPreference";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Web Preference Type Id
	 */
	@Getter
	@Setter
	private String webPreferenceTypeId;
	/**
	 * Web Preference Value
	 */
	@Getter
	@Setter
	private String webPreferenceValue;

	public enum Fields {
		userLoginId, partyId, visitId, webPreferenceTypeId, webPreferenceValue
	}

	public WebUserPreference(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		partyId = (String) value.get(Fields.partyId.name());
		visitId = (String) value.get(Fields.visitId.name());
		webPreferenceTypeId = (String) value.get(Fields.webPreferenceTypeId
				.name());
		webPreferenceValue = (String) value.get(Fields.webPreferenceValue
				.name());
	}

	public static WebUserPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebUserPreference(value);
	}

	public static List<WebUserPreference> fromValues(List<GenericValue> values) {
		List<WebUserPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebUserPreference(value));
		}
		return entities;
	}
}