package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource
 */
@FieldNameConstants
public class DataResource implements Serializable {

	public static final long serialVersionUID = 3685436140999049216L;
	public static final String NAME = "DataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
	/**
	 * Data Template Type Id
	 */
	@Getter
	@Setter
	private String dataTemplateTypeId;
	/**
	 * Data Category Id
	 */
	@Getter
	@Setter
	private String dataCategoryId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Data Resource Name
	 */
	@Getter
	@Setter
	private String dataResourceName;
	/**
	 * Locale String
	 */
	@Getter
	@Setter
	private String localeString;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
	/**
	 * Object Info
	 */
	@Getter
	@Setter
	private String objectInfo;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Related Detail Id
	 */
	@Getter
	@Setter
	private String relatedDetailId;
	/**
	 * Is Public
	 */
	@Getter
	@Setter
	private String isPublic;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public DataResource(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		dataResourceTypeId = (String) value.get(FIELD_DATA_RESOURCE_TYPE_ID);
		dataTemplateTypeId = (String) value.get(FIELD_DATA_TEMPLATE_TYPE_ID);
		dataCategoryId = (String) value.get(FIELD_DATA_CATEGORY_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		dataResourceName = (String) value.get(FIELD_DATA_RESOURCE_NAME);
		localeString = (String) value.get(FIELD_LOCALE_STRING);
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		characterSetId = (String) value.get(FIELD_CHARACTER_SET_ID);
		objectInfo = (String) value.get(FIELD_OBJECT_INFO);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		relatedDetailId = (String) value.get(FIELD_RELATED_DETAIL_ID);
		isPublic = (String) value.get(FIELD_IS_PUBLIC);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResource(value);
	}

	public static List<DataResource> fromValues(List<GenericValue> values) {
		List<DataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResource(value));
		}
		return entities;
	}
}