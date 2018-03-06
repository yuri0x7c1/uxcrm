package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Electronic Text
 */
public class ElectronicText implements Serializable {

	public static final long serialVersionUID = 1964119560662254592L;
	public static final String NAME = "ElectronicText";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Text Data
	 */
	@Getter
	@Setter
	private String textData;

	public enum Fields {
		dataResourceId, textData
	}

	public ElectronicText(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		textData = (String) value.get(Fields.textData.name());
	}

	public static ElectronicText fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ElectronicText(value);
	}

	public static List<ElectronicText> fromValues(List<GenericValue> values) {
		List<ElectronicText> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ElectronicText(value));
		}
		return entities;
	}
}