package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Image Data Resource
 */
public class ImageDataResource implements Serializable {

	public static final long serialVersionUID = 6718880281572409344L;
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
		dataResourceId, imageData, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ImageDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		imageData = (byte[]) value.get(Fields.imageData.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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