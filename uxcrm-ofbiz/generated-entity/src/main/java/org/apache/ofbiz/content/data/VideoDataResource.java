package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Video Data Resource
 */
public class VideoDataResource implements Serializable {

	public static final long serialVersionUID = 2043262270179277824L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		dataResourceId, videoData, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public VideoDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		videoData = (byte[]) value.get(Fields.videoData.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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