package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContentOperation implements Serializable {

	public static final long serialVersionUID = 3303363418746017792L;
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

	public ContentOperation(GenericValue value) {
		contentOperationId = (String) value.get(FIELD_CONTENT_OPERATION_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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