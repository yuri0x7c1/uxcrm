package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Video Data Resource
 */
public class VideoDataResource implements Serializable {

	public static final long serialVersionUID = 2013679559344510976L;
	public static final String NAME = "VideoDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Video Data
	 */
	@Getter
	@Setter
	private byte[] videoData;

	public enum Fields {
		dataResourceId, videoData
	}

	public VideoDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		videoData = (byte[]) value.get(Fields.videoData.name());
	}

	public static VideoDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VideoDataResource(value);
	}

	public static List<VideoDataResource> fromValues(List<GenericValue> values) {
		List<VideoDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VideoDataResource(value));
		}
		return entities;
	}
}