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
 * Content Meta Data
 */
@FieldNameConstants
public class ContentMetaData implements Serializable {

	public static final long serialVersionUID = 7019875386766779392L;
	public static final String NAME = "ContentMetaData";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Meta Data Predicate Id
	 */
	@Getter
	@Setter
	private String metaDataPredicateId;
	/**
	 * Meta Data Value
	 */
	@Getter
	@Setter
	private String metaDataValue;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
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

	public ContentMetaData(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		metaDataPredicateId = (String) value.get(FIELD_META_DATA_PREDICATE_ID);
		metaDataValue = (String) value.get(FIELD_META_DATA_VALUE);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentMetaData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentMetaData(value);
	}

	public static List<ContentMetaData> fromValues(List<GenericValue> values) {
		List<ContentMetaData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentMetaData(value));
		}
		return entities;
	}
}