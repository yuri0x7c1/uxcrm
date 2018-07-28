package org.apache.ofbiz.content.document;

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
public class Document implements Serializable {

	public static final long serialVersionUID = 2795097896271356928L;
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

	public enum Fields {
		documentId, documentTypeId, dateCreated, comments, documentLocation, documentText, imageData, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Document(GenericValue value) {
		documentId = (String) value.get(Fields.documentId.name());
		documentTypeId = (String) value.get(Fields.documentTypeId.name());
		dateCreated = (Timestamp) value.get(Fields.dateCreated.name());
		comments = (String) value.get(Fields.comments.name());
		documentLocation = (String) value.get(Fields.documentLocation.name());
		documentText = (String) value.get(Fields.documentText.name());
		imageData = (Object) value.get(Fields.imageData.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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