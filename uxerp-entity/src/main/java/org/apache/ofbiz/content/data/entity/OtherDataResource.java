package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Other Data Resource
 */
public class OtherDataResource implements Serializable {

	public static final long serialVersionUID = 7886983535212356608L;
	public static final String NAME = "OtherDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Data Resource Content
	 */
	@Getter
	@Setter
	private byte[] dataResourceContent;

	public enum Fields {
		dataResourceId, dataResourceContent
	}

	public OtherDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		dataResourceContent = (byte[]) value.get(Fields.dataResourceContent
				.name());
	}

	public static OtherDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OtherDataResource(value);
	}

	public static List<OtherDataResource> fromValues(List<GenericValue> values) {
		List<OtherDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OtherDataResource(value));
		}
		return entities;
	}
}