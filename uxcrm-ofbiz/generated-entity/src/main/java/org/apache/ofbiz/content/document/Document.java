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
 * Document
 */
@FieldNameConstants
public class Document implements Serializable {

	public static final long serialVersionUID = 1140472286800081920L;
	public static final String NAME = "Document";
	/**
	 * Document Id
	 */
	@Getter
	@Setter
	private String documentId;
	/**
	 * Document Type Id
	 */
	@Getter
	@Setter
	private String documentTypeId;
	/**
	 * Date Created
	 */
	@Getter
	@Setter
	private Timestamp dateCreated;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Document Location
	 */
	@Getter
	@Setter
	private String documentLocation;
	/**
	 * Document Text
	 */
	@Getter
	@Setter
	private String documentText;
	/**
	 * Image Data
	 */
	@Getter
	@Setter
	private Object imageData;
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

	public Document(GenericValue value) {
		documentId = (String) value.get(FIELD_DOCUMENT_ID);
		documentTypeId = (String) value.get(FIELD_DOCUMENT_TYPE_ID);
		dateCreated = (Timestamp) value.get(FIELD_DATE_CREATED);
		comments = (String) value.get(FIELD_COMMENTS);
		documentLocation = (String) value.get(FIELD_DOCUMENT_LOCATION);
		documentText = (String) value.get(FIELD_DOCUMENT_TEXT);
		imageData = (Object) value.get(FIELD_IMAGE_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Document fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Document(value);
	}

	public static List<Document> fromValues(List<GenericValue> values) {
		List<Document> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Document(value));
		}
		return entities;
	}
}