package org.apache.ofbiz.content.content;

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
public class ContentMetaData implements Serializable {

	public static final long serialVersionUID = 3333422368993872896L;
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

	public enum Fields {
		contentId, metaDataPredicateId, metaDataValue, dataSourceId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentMetaData(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		metaDataPredicateId = (String) value.get(Fields.metaDataPredicateId
				.name());
		metaDataValue = (String) value.get(Fields.metaDataValue.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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