package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Platform Type
 */
public class PlatformType implements Serializable {

	public static final long serialVersionUID = 879599238919648256L;
	public static final String NAME = "PlatformType";
	/**
	 * Platform Type Id
	 */
	@Getter
	@Setter
	private String platformTypeId;
	/**
	 * Platform Name
	 */
	@Getter
	@Setter
	private String platformName;
	/**
	 * Platform Version
	 */
	@Getter
	@Setter
	private String platformVersion;

	public enum Fields {
		platformTypeId, platformName, platformVersion
	}

	public PlatformType(GenericValue value) {
		platformTypeId = (String) value.get(Fields.platformTypeId.name());
		platformName = (String) value.get(Fields.platformName.name());
		platformVersion = (String) value.get(Fields.platformVersion.name());
	}

	public static PlatformType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PlatformType(value);
	}

	public static List<PlatformType> fromValues(List<GenericValue> values) {
		List<PlatformType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PlatformType(value));
		}
		return entities;
	}
}