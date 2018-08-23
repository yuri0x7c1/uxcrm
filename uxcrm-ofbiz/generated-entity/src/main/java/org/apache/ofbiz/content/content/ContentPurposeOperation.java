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
 * Content Purpose Operation
 */
@FieldNameConstants
public class ContentPurposeOperation implements Serializable {

	public static final long serialVersionUID = 8908921888315821056L;
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

	public ContentPurposeOperation(GenericValue value) {
		contentPurposeTypeId = (String) value
				.get(FIELD_CONTENT_PURPOSE_TYPE_ID);
		contentOperationId = (String) value.get(FIELD_CONTENT_OPERATION_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		privilegeEnumId = (String) value.get(FIELD_PRIVILEGE_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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