package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Revision
 */
public class ContentRevision implements Serializable {

	public static final long serialVersionUID = 2050784237197878272L;
	public static final String NAME = "ContentRevision";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Revision Seq Id
	 */
	@Getter
	@Setter
	private String contentRevisionSeqId;
	/**
	 * Committed By Party Id
	 */
	@Getter
	@Setter
	private String committedByPartyId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		contentId, contentRevisionSeqId, committedByPartyId, comments
	}

	public ContentRevision(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
		committedByPartyId = (String) value.get(Fields.committedByPartyId
				.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static ContentRevision fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentRevision(value);
	}

	public static List<ContentRevision> fromValues(List<GenericValue> values) {
		List<ContentRevision> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentRevision(value));
		}
		return entities;
	}
}