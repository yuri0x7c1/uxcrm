package org.apache.ofbiz.content.data.entity;

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
public class DataResource implements Serializable {

	public static final long serialVersionUID = 1047430509553298432L;
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

	public enum Fields {
		dataResourceId, dataResourceTypeId, dataTemplateTypeId, dataCategoryId, dataSourceId, statusId, dataResourceName, localeString, mimeTypeId, characterSetId, objectInfo, surveyId, surveyResponseId, relatedDetailId, isPublic, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin
	}

	public DataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
				.name());
		dataTemplateTypeId = (String) value.get(Fields.dataTemplateTypeId
				.name());
		dataCategoryId = (String) value.get(Fields.dataCategoryId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		statusId = (String) value.get(Fields.statusId.name());
		dataResourceName = (String) value.get(Fields.dataResourceName.name());
		localeString = (String) value.get(Fields.localeString.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		characterSetId = (String) value.get(Fields.characterSetId.name());
		objectInfo = (String) value.get(Fields.objectInfo.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		relatedDetailId = (String) value.get(Fields.relatedDetailId.name());
		isPublic = (String) value.get(Fields.isPublic.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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