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
 * File Extension
 */
@FieldNameConstants
public class FileExtension implements Serializable {

	public static final long serialVersionUID = 6341515084454350848L;
	public static final String NAME = "FileExtension";
	/**
	 * File Extension Id
	 */
	@Getter
	@Setter
	private String fileExtensionId;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
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

	public FileExtension(GenericValue value) {
		fileExtensionId = (String) value.get(FIELD_FILE_EXTENSION_ID);
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FileExtension fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FileExtension(value);
	}

	public static List<FileExtension> fromValues(List<GenericValue> values) {
		List<FileExtension> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FileExtension(value));
		}
		return entities;
	}
}