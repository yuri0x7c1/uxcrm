package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Operation
 */
public class ContentOperation implements Serializable {

	public static final long serialVersionUID = 1412609081452377088L;
	public static final String NAME = "ContentOperation";
	/**
	 * Content Operation Id
	 */
	@Getter
	@Setter
	private String contentOperationId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		contentOperationId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentOperation(GenericValue value) {
		contentOperationId = (String) value.get(Fields.contentOperationId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContentOperation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentOperation(value);
	}

	public static List<ContentOperation> fromValues(List<GenericValue> values) {
		List<ContentOperation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentOperation(value));
		}
		return entities;
	}
}