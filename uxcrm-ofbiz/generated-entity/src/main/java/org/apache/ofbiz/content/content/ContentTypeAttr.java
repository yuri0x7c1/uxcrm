package org.apache.ofbiz.content.content;

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
public class ContentTypeAttr implements Serializable {

	public static final long serialVersionUID = 3205000566957742080L;
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

	public enum Fields {
		contentTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentTypeAttr(GenericValue value) {
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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