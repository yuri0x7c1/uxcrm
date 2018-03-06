package org.apache.ofbiz.content.compdoc.entity.view;

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

	public static final long serialVersionUID = 2177883413522538496L;
	public static final String NAME = "MaxRevisionItemView";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
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
		contentId, itemContentId, contentRevisionSeqId
	}

	public MaxRevisionItemView(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		itemContentId = (String) value.get(Fields.itemContentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
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