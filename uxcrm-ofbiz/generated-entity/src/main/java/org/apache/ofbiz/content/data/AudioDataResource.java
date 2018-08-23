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
 * Audio Data Resource
 */
@FieldNameConstants
public class AudioDataResource implements Serializable {

	public static final long serialVersionUID = 4652547865102468096L;
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

	public AudioDataResource(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		audioData = (byte[]) value.get(FIELD_AUDIO_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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