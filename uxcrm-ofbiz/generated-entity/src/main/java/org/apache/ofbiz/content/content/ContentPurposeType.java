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
 * Content Purpose Type
 */
@FieldNameConstants
public class ContentPurposeType implements Serializable {

	public static final long serialVersionUID = 4698345027096116224L;
	public static final String NAME = "ContentPurposeType";
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
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

	public ContentPurposeType(GenericValue value) {
		contentPurposeTypeId = (String) value
				.get(FIELD_CONTENT_PURPOSE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentPurposeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurposeType(value);
	}

	public static List<ContentPurposeType> fromValues(List<GenericValue> values) {
		List<ContentPurposeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurposeType(value));
		}
		return entities;
	}
}