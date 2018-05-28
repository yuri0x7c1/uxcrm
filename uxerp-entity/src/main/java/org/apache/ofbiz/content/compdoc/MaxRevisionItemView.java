package org.apache.ofbiz.content.compdoc;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Max Revision Item View
 */
public class MaxRevisionItemView implements Serializable {

	public static final long serialVersionUID = 7507304849789033472L;
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

	public enum Fields {
		rootRevisionContentId, itemContentId, contentRevisionSeqId, maxRevisionSeqId
	}

	public MaxRevisionItemView(GenericValue value) {
		rootRevisionContentId = (String) value.get(Fields.rootRevisionContentId
				.name());
		itemContentId = (String) value.get(Fields.itemContentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
		maxRevisionSeqId = (String) value.get(Fields.maxRevisionSeqId.name());
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