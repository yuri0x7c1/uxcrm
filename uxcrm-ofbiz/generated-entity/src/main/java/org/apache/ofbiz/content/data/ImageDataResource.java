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
 * Image Data Resource
 */
@FieldNameConstants
public class ImageDataResource implements Serializable {

	public static final long serialVersionUID = 6256949180652316672L;
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

	public ImageDataResource(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		imageData = (byte[]) value.get(FIELD_IMAGE_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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