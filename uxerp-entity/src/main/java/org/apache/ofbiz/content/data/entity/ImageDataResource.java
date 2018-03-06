package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Image Data Resource
 */
public class ImageDataResource implements Serializable {

	public static final long serialVersionUID = 6611681353312563200L;
	public static final String NAME = "ImageDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Image Data
	 */
	@Getter
	@Setter
	private byte[] imageData;

	public enum Fields {
		dataResourceId, imageData
	}

	public ImageDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		imageData = (byte[]) value.get(Fields.imageData.name());
	}

	public static ImageDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ImageDataResource(value);
	}

	public static List<ImageDataResource> fromValues(List<GenericValue> values) {
		List<ImageDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ImageDataResource(value));
		}
		return entities;
	}
}