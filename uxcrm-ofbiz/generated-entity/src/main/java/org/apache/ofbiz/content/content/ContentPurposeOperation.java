package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Purpose Operation
 */
public class ContentPurposeOperation implements Serializable {

	public static final long serialVersionUID = 8279271414921410560L;
	public static final String NAME = "ContentPurposeOperation";
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
	/**
	 * Content Operation Id
	 */
	@Getter
	@Setter
	private String contentOperationId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Privilege Enum Id
	 */
	@Getter
	@Setter
	private String privilegeEnumId;
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
		contentPurposeTypeId, contentOperationId, roleTypeId, statusId, privilegeEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentPurposeOperation(GenericValue value) {
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		contentOperationId = (String) value.get(Fields.contentOperationId
				.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		privilegeEnumId = (String) value.get(Fields.privilegeEnumId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContentPurposeOperation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurposeOperation(value);
	}

	public static List<ContentPurposeOperation> fromValues(
			List<GenericValue> values) {
		List<ContentPurposeOperation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurposeOperation(value));
		}
		return entities;
	}
}