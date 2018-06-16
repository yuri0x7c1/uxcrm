package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc Type
 */
public class ContentAssocType implements Serializable {

	public static final long serialVersionUID = 4538172762866211840L;
	public static final String NAME = "ContentAssocType";
	/**
	 * Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String contentAssocTypeId;
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
		contentAssocTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentAssocType(GenericValue value) {
		contentAssocTypeId = (String) value.get(Fields.contentAssocTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContentAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocType(value);
	}

	public static List<ContentAssocType> fromValues(List<GenericValue> values) {
		List<ContentAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocType(value));
		}
		return entities;
	}
}