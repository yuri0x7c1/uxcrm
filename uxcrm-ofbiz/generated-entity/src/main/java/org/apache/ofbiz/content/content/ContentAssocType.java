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
 * Content Assoc Type
 */
@FieldNameConstants
public class ContentAssocType implements Serializable {

	public static final long serialVersionUID = 5755553863454391296L;
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

	public ContentAssocType(GenericValue value) {
		contentAssocTypeId = (String) value.get(FIELD_CONTENT_ASSOC_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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