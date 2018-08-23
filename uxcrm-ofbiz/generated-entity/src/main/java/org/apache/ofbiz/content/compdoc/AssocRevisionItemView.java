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
 * Assoc Revision Item View
 */
@FieldNameConstants
public class AssocRevisionItemView implements Serializable {

	public static final long serialVersionUID = 7370969057175004160L;
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
	 * Root Revision Content Id
	 */
	@Getter
	@Setter
	private String rootRevisionContentId;
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
	/**
	 * Max Revision Seq Id
	 */
	@Getter
	@Setter
	private String maxRevisionSeqId;

	public AssocRevisionItemView(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentIdTo = (String) value.get(FIELD_CONTENT_ID_TO);
		contentAssocTypeId = (String) value.get(FIELD_CONTENT_ASSOC_TYPE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		rootRevisionContentId = (String) value
				.get(FIELD_ROOT_REVISION_CONTENT_ID);
		itemContentId = (String) value.get(FIELD_ITEM_CONTENT_ID);
		contentRevisionSeqId = (String) value
				.get(FIELD_CONTENT_REVISION_SEQ_ID);
		maxRevisionSeqId = (String) value.get(FIELD_MAX_REVISION_SEQ_ID);
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