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
 * Content Revision Item
 */
@FieldNameConstants
public class ContentRevisionItem implements Serializable {

	public static final long serialVersionUID = 1662729645261846528L;
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

	public ContentRevisionItem(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentRevisionSeqId = (String) value
				.get(FIELD_CONTENT_REVISION_SEQ_ID);
		itemContentId = (String) value.get(FIELD_ITEM_CONTENT_ID);
		oldDataResourceId = (String) value.get(FIELD_OLD_DATA_RESOURCE_ID);
		newDataResourceId = (String) value.get(FIELD_NEW_DATA_RESOURCE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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