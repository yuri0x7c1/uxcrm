package org.apache.ofbiz.content.document;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Document Type Attr
 */
public class DocumentTypeAttr implements Serializable {

	public static final long serialVersionUID = 2704271626417779712L;
	public static final String NAME = "DocumentTypeAttr";
	/**
	 * Document Type Id
	 */
	@Getter
	@Setter
	private String documentTypeId;
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

	public enum Fields {
		documentTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DocumentTypeAttr(GenericValue value) {
		documentTypeId = (String) value.get(Fields.documentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static DocumentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DocumentTypeAttr(value);
	}

	public static List<DocumentTypeAttr> fromValues(List<GenericValue> values) {
		List<DocumentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DocumentTypeAttr(value));
		}
		return entities;
	}
}