package org.apache.ofbiz.content.compdoc;

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
public class ContentAssocAndContentPurpose implements Serializable {

	public static final long serialVersionUID = 1668610112819211264L;
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

	public enum Fields {
		contentId, contentIdTo, contentAssocTypeId, fromDate, thruDate, dataSourceId, mapKey, contentPurposeTypeId, sequenceNum
	}

	public ContentAssocAndContentPurpose(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentIdTo = (String) value.get(Fields.contentIdTo.name());
		contentAssocTypeId = (String) value.get(Fields.contentAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		mapKey = (String) value.get(Fields.mapKey.name());
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
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