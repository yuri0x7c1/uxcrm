package org.apache.ofbiz.content.document;

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
public class DocumentAttribute implements Serializable {

	public static final long serialVersionUID = 1654725864915350528L;
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

	public enum Fields {
		documentId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DocumentAttribute(GenericValue value) {
		documentId = (String) value.get(Fields.documentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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