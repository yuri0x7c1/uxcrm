package org.apache.ofbiz.content.compdoc;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc And Content Purpose
 */
@FieldNameConstants
public class ContentAssocAndContentPurpose implements Serializable {

	public static final long serialVersionUID = 5940206878808150016L;
	public static final String NAME = "ContentAssocAndContentPurpose";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Id To
	 */
	@Getter
	@Setter
	private String contentIdTo;
	/**
	 * Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String contentAssocTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Map Key
	 */
	@Getter
	@Setter
	private String mapKey;
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

	public ContentAssocAndContentPurpose(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentIdTo = (String) value.get(FIELD_CONTENT_ID_TO);
		contentAssocTypeId = (String) value.get(FIELD_CONTENT_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		mapKey = (String) value.get(FIELD_MAP_KEY);
		contentPurposeTypeId = (String) value
				.get(FIELD_CONTENT_PURPOSE_TYPE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
	}

	public static ContentAssocAndContentPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocAndContentPurpose(value);
	}

	public static List<ContentAssocAndContentPurpose> fromValues(
			List<GenericValue> values) {
		List<ContentAssocAndContentPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocAndContentPurpose(value));
		}
		return entities;
	}
}