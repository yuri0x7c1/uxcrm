package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Revision
 */
public class ContentRevision implements Serializable {

	public static final long serialVersionUID = 826458948099557376L;
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

	public enum Fields {
		contentId, contentRevisionSeqId, committedByPartyId, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentRevision(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
		committedByPartyId = (String) value.get(Fields.committedByPartyId
				.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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