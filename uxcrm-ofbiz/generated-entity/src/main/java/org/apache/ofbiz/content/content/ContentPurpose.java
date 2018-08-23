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
 * Content Purpose
 */
@FieldNameConstants
public class ContentPurpose implements Serializable {

	public static final long serialVersionUID = 6632739562228066304L;
	public static final String NAME = "ContentPurpose";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public ContentPurpose(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentPurposeTypeId = (String) value
				.get(FIELD_CONTENT_PURPOSE_TYPE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurpose(value);
	}

	public static List<ContentPurpose> fromValues(List<GenericValue> values) {
		List<ContentPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurpose(value));
		}
		return entities;
	}
}