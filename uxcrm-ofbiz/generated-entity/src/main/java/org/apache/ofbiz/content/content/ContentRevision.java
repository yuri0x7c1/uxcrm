package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContentRevision implements Serializable {

	public static final long serialVersionUID = 8802725694450239488L;
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

	public ContentRevision(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentRevisionSeqId = (String) value
				.get(FIELD_CONTENT_REVISION_SEQ_ID);
		committedByPartyId = (String) value.get(FIELD_COMMITTED_BY_PARTY_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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