package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class VideoDataResource implements Serializable {

	public static final long serialVersionUID = 8614670589905412096L;
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

	public VideoDataResource(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		videoData = (byte[]) value.get(FIELD_VIDEO_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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