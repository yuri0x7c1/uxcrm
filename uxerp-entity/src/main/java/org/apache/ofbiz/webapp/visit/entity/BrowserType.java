package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Browser Type
 */
public class BrowserType implements Serializable {

	public static final long serialVersionUID = 729908300897802240L;
	public static final String NAME = "BrowserType";
	/**
	 * Browser Type Id
	 */
	@Getter
	@Setter
	private String browserTypeId;
	/**
	 * Browser Name
	 */
	@Getter
	@Setter
	private String browserName;
	/**
	 * Browser Version
	 */
	@Getter
	@Setter
	private String browserVersion;

	public enum Fields {
		browserTypeId, browserName, browserVersion
	}

	public BrowserType(GenericValue value) {
		browserTypeId = (String) value.get(Fields.browserTypeId.name());
		browserName = (String) value.get(Fields.browserName.name());
		browserVersion = (String) value.get(Fields.browserVersion.name());
	}

	public static BrowserType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BrowserType(value);
	}

	public static List<BrowserType> fromValues(List<GenericValue> values) {
		List<BrowserType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BrowserType(value));
		}
		return entities;
	}
}