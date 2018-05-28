package org.apache.ofbiz.content.data;

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
public class AudioDataResource implements Serializable {

	public static final long serialVersionUID = 2506917509335476224L;
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

	public enum Fields {
		dataResourceId, audioData, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AudioDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		audioData = (byte[]) value.get(Fields.audioData.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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