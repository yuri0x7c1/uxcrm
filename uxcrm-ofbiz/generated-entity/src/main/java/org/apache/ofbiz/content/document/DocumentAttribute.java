package org.apache.ofbiz.content.document;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Document Attribute
 */
@FieldNameConstants
public class DocumentAttribute implements Serializable {

	public static final long serialVersionUID = 711584836974370816L;
	public static final String NAME = "DocumentAttribute";
	/**
	 * Document Id
	 */
	@Getter
	@Setter
	private String documentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public DocumentAttribute(GenericValue value) {
		documentId = (String) value.get(FIELD_DOCUMENT_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DocumentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DocumentAttribute(value);
	}

	public static List<DocumentAttribute> fromValues(List<GenericValue> values) {
		List<DocumentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DocumentAttribute(value));
		}
		return entities;
	}
}