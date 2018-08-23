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
 * Data Resource Content View
 */
@FieldNameConstants
public class DataResourceContentView implements Serializable {

	public static final long serialVersionUID = 5844486434579991552L;
	public static final String NAME = "DataResourceContentView";
	/**
	 * Data Resource Name
	 */
	@Getter
	@Setter
	private String dataResourceName;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Data Template Type Id
	 */
	@Getter
	@Setter
	private String dataTemplateTypeId;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Data Category Id
	 */
	@Getter
	@Setter
	private String dataCategoryId;
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Locale String
	 */
	@Getter
	@Setter
	private String localeString;
	/**
	 * Related Detail Id
	 */
	@Getter
	@Setter
	private String relatedDetailId;
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Is Public
	 */
	@Getter
	@Setter
	private String isPublic;
	/**
	 * Object Info
	 */
	@Getter
	@Setter
	private String objectInfo;
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Co Owner Content Id
	 */
	@Getter
	@Setter
	private String coOwnerContentId;
	/**
	 * Co Content Id
	 */
	@Getter
	@Setter
	private String coContentId;
	/**
	 * Co Content Type Id
	 */
	@Getter
	@Setter
	private String coContentTypeId;
	/**
	 * Co Description
	 */
	@Getter
	@Setter
	private String coDescription;
	/**
	 * Co Mime Type Id
	 */
	@Getter
	@Setter
	private String coMimeTypeId;
	/**
	 * Co Child Leaf Count
	 */
	@Getter
	@Setter
	private Long coChildLeafCount;
	/**
	 * Co Privilege Enum Id
	 */
	@Getter
	@Setter
	private String coPrivilegeEnumId;
	/**
	 * Co Data Source Id
	 */
	@Getter
	@Setter
	private String coDataSourceId;
	/**
	 * Co Last Modified By User Login
	 */
	@Getter
	@Setter
	private String coLastModifiedByUserLogin;
	/**
	 * Co Data Resource Id
	 */
	@Getter
	@Setter
	private String coDataResourceId;
	/**
	 * Co Created By User Login
	 */
	@Getter
	@Setter
	private String coCreatedByUserLogin;
	/**
	 * Co Template Data Resource Id
	 */
	@Getter
	@Setter
	private String coTemplateDataResourceId;
	/**
	 * Co Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp coLastModifiedDate;
	/**
	 * Co Instance Of Content Id
	 */
	@Getter
	@Setter
	private String coInstanceOfContentId;
	/**
	 * Co Service Name
	 */
	@Getter
	@Setter
	private String coServiceName;
	/**
	 * Co Custom Method Id
	 */
	@Getter
	@Setter
	private String coCustomMethodId;
	/**
	 * Co Character Set Id
	 */
	@Getter
	@Setter
	private String coCharacterSetId;
	/**
	 * Co Content Name
	 */
	@Getter
	@Setter
	private String coContentName;
	/**
	 * Co Created Date
	 */
	@Getter
	@Setter
	private Timestamp coCreatedDate;
	/**
	 * Co Status Id
	 */
	@Getter
	@Setter
	private String coStatusId;
	/**
	 * Co Locale String
	 */
	@Getter
	@Setter
	private String coLocaleString;
	/**
	 * Co Decorator Content Id
	 */
	@Getter
	@Setter
	private String coDecoratorContentId;
	/**
	 * Co Child Branch Count
	 */
	@Getter
	@Setter
	private Long coChildBranchCount;

	public DataResourceContentView(GenericValue value) {
		dataResourceName = (String) value.get(FIELD_DATA_RESOURCE_NAME);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		dataTemplateTypeId = (String) value.get(FIELD_DATA_TEMPLATE_TYPE_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		dataCategoryId = (String) value.get(FIELD_DATA_CATEGORY_ID);
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		characterSetId = (String) value.get(FIELD_CHARACTER_SET_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		localeString = (String) value.get(FIELD_LOCALE_STRING);
		relatedDetailId = (String) value.get(FIELD_RELATED_DETAIL_ID);
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		isPublic = (String) value.get(FIELD_IS_PUBLIC);
		objectInfo = (String) value.get(FIELD_OBJECT_INFO);
		dataResourceTypeId = (String) value.get(FIELD_DATA_RESOURCE_TYPE_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		coOwnerContentId = (String) value.get(FIELD_CO_OWNER_CONTENT_ID);
		coContentId = (String) value.get(FIELD_CO_CONTENT_ID);
		coContentTypeId = (String) value.get(FIELD_CO_CONTENT_TYPE_ID);
		coDescription = (String) value.get(FIELD_CO_DESCRIPTION);
		coMimeTypeId = (String) value.get(FIELD_CO_MIME_TYPE_ID);
		coChildLeafCount = (Long) value.get(FIELD_CO_CHILD_LEAF_COUNT);
		coPrivilegeEnumId = (String) value.get(FIELD_CO_PRIVILEGE_ENUM_ID);
		coDataSourceId = (String) value.get(FIELD_CO_DATA_SOURCE_ID);
		coLastModifiedByUserLogin = (String) value
				.get(FIELD_CO_LAST_MODIFIED_BY_USER_LOGIN);
		coDataResourceId = (String) value.get(FIELD_CO_DATA_RESOURCE_ID);
		coCreatedByUserLogin = (String) value
				.get(FIELD_CO_CREATED_BY_USER_LOGIN);
		coTemplateDataResourceId = (String) value
				.get(FIELD_CO_TEMPLATE_DATA_RESOURCE_ID);
		coLastModifiedDate = (Timestamp) value.get(FIELD_CO_LAST_MODIFIED_DATE);
		coInstanceOfContentId = (String) value
				.get(FIELD_CO_INSTANCE_OF_CONTENT_ID);
		coServiceName = (String) value.get(FIELD_CO_SERVICE_NAME);
		coCustomMethodId = (String) value.get(FIELD_CO_CUSTOM_METHOD_ID);
		coCharacterSetId = (String) value.get(FIELD_CO_CHARACTER_SET_ID);
		coContentName = (String) value.get(FIELD_CO_CONTENT_NAME);
		coCreatedDate = (Timestamp) value.get(FIELD_CO_CREATED_DATE);
		coStatusId = (String) value.get(FIELD_CO_STATUS_ID);
		coLocaleString = (String) value.get(FIELD_CO_LOCALE_STRING);
		coDecoratorContentId = (String) value
				.get(FIELD_CO_DECORATOR_CONTENT_ID);
		coChildBranchCount = (Long) value.get(FIELD_CO_CHILD_BRANCH_COUNT);
	}

	public static DataResourceContentView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceContentView(value);
	}

	public static List<DataResourceContentView> fromValues(
			List<GenericValue> values) {
		List<DataResourceContentView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceContentView(value));
		}
		return entities;
	}
}