package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Type
 */
public class ContentType implements Serializable {

	public static final long serialVersionUID = 2056917893739338752L;
	public static final String NAME = "ContentType";
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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
		contentTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentType(GenericValue value) {
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentType(value);
	}

	public static List<ContentType> fromValues(List<GenericValue> values) {
		List<ContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentType(value));
		}
		return entities;
	}
}