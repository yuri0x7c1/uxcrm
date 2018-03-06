package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Audio Data Resource
 */
public class AudioDataResource implements Serializable {

	public static final long serialVersionUID = 6752809969731531776L;
	public static final String NAME = "AudioDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Audio Data
	 */
	@Getter
	@Setter
	private byte[] audioData;

	public enum Fields {
		dataResourceId, audioData
	}

	public AudioDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		audioData = (byte[]) value.get(Fields.audioData.name());
	}

	public static AudioDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AudioDataResource(value);
	}

	public static List<AudioDataResource> fromValues(List<GenericValue> values) {
		List<AudioDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AudioDataResource(value));
		}
		return entities;
	}
}