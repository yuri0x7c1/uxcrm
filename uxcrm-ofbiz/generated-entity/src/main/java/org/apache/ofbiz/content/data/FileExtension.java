package org.apache.ofbiz.content.data;

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
public class FileExtension implements Serializable {

	public static final long serialVersionUID = 4041503556813674496L;
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

	public enum Fields {
		fileExtensionId, mimeTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FileExtension(GenericValue value) {
		fileExtensionId = (String) value.get(Fields.fileExtensionId.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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