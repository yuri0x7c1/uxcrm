package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Revision Item
 */
public class ContentRevisionItem implements Serializable {

	public static final long serialVersionUID = 7533605485875298304L;
	public static final String NAME = "ContentRevisionItem";
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
	 * Item Content Id
	 */
	@Getter
	@Setter
	private String itemContentId;
	/**
	 * Old Data Resource Id
	 */
	@Getter
	@Setter
	private String oldDataResourceId;
	/**
	 * New Data Resource Id
	 */
	@Getter
	@Setter
	private String newDataResourceId;
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
		contentId, contentRevisionSeqId, itemContentId, oldDataResourceId, newDataResourceId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentRevisionItem(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentRevisionSeqId = (String) value.get(Fields.contentRevisionSeqId
				.name());
		itemContentId = (String) value.get(Fields.itemContentId.name());
		oldDataResourceId = (String) value.get(Fields.oldDataResourceId.name());
		newDataResourceId = (String) value.get(Fields.newDataResourceId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContentRevisionItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentRevisionItem(value);
	}

	public static List<ContentRevisionItem> fromValues(List<GenericValue> values) {
		List<ContentRevisionItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentRevisionItem(value));
		}
		return entities;
	}
}