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
 * Content Type Attr
 */
@FieldNameConstants
public class ContentTypeAttr implements Serializable {

	public static final long serialVersionUID = 4279521219086735360L;
	public static final String NAME = "ContentTypeAttr";
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public ContentTypeAttr(GenericValue value) {
		contentTypeId = (String) value.get(FIELD_CONTENT_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentTypeAttr(value);
	}

	public static List<ContentTypeAttr> fromValues(List<GenericValue> values) {
		List<ContentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentTypeAttr(value));
		}
		return entities;
	}
}