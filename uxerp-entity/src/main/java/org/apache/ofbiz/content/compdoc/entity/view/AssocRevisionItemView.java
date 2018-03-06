package org.apache.ofbiz.content.compdoc.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Assoc Revision Item View
 */
public class AssocRevisionItemView implements Serializable {

	public static final long serialVersionUID = 3822468572594839552L;
	public static final String NAME = "AssocRevisionItemView";
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
		contentId, contentIdTo, contentAssocTypeId, thruDate, fromDate, sequenceNum, itemContentId, contentRevisionSeqId
	}

	public AssocRevisionItemView(GenericValue value) {
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

	public static AssocRevisionItemView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AssocRevisionItemView(value);
	}

	public static List<AssocRevisionItemView> fromValues(
			List<GenericValue> values) {
		List<AssocRevisionItemView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AssocRevisionItemView(value));
		}
		return entities;
	}
}