package org.apache.ofbiz.content.compdoc.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc Revision Item View
 */
public class ContentAssocRevisionItemView implements Serializable {

	public static final long serialVersionUID = 2212649442314603520L;
	public static final String NAME = "ContentAssocRevisionItemView";
	/**
	 * Instance Of Content Id
	 */
	@Getter
	@Setter
	private String instanceOfContentId;
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
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
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Item Content Id
	 */
	@Getter
	@Setter
	private String itemContentId;
	/**
	 * Content Revision Seq Id
	 */
	@Getter
	@Setter
	private String contentRevisionSeqId;

	public enum Fields {
		instanceOfContentId, dataResourceId, contentId, contentIdTo, contentAssocTypeId, thruDate, fromDate, sequenceNum, itemContentId, contentRevisionSeqId
	}

	public ContentAssocRevisionItemView(GenericValue value) {
		instanceOfContentId = (String) value.get(Fields.instanceOfContentId
				.name());
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		contentId = (String) value.get(Fields.contentId.name());
		contentIdTo = (String) value.get(Fields.contentIdTo.name());
		contentAssocTypeId = (String) value.get(Fields.contentAssocTypeId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		itemContentId = (String) value.get(Fields.itemContentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
	}

	public static ContentAssocRevisionItemView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocRevisionItemView(value);
	}

	public static List<ContentAssocRevisionItemView> fromValues(
			List<GenericValue> values) {
		List<ContentAssocRevisionItemView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocRevisionItemView(value));
		}
		return entities;
	}
}