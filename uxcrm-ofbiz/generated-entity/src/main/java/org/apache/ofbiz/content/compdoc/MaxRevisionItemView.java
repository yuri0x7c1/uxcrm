package org.apache.ofbiz.content.compdoc;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Max Revision Item View
 */
@FieldNameConstants
public class MaxRevisionItemView implements Serializable {

	public static final long serialVersionUID = 4179257536941426688L;
	public static final String NAME = "MaxRevisionItemView";
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

	public MaxRevisionItemView(GenericValue value) {
		rootRevisionContentId = (String) value
				.get(FIELD_ROOT_REVISION_CONTENT_ID);
		itemContentId = (String) value.get(FIELD_ITEM_CONTENT_ID);
		contentRevisionSeqId = (String) value
				.get(FIELD_CONTENT_REVISION_SEQ_ID);
		maxRevisionSeqId = (String) value.get(FIELD_MAX_REVISION_SEQ_ID);
	}

	public static MaxRevisionItemView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MaxRevisionItemView(value);
	}

	public static List<MaxRevisionItemView> fromValues(List<GenericValue> values) {
		List<MaxRevisionItemView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MaxRevisionItemView(value));
		}
		return entities;
	}
}