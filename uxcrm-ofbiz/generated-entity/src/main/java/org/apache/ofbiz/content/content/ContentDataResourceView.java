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
 * Content Data Resource View
 */
@FieldNameConstants
public class ContentDataResourceView implements Serializable {

	public static final long serialVersionUID = 5285377531678048256L;
	public static final String NAME = "ContentDataResourceView";
	/**
	 * Owner Content Id
	 */
	@Getter
	@Setter
	private String ownerContentId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Child Leaf Count
	 */
	@Getter
	@Setter
	private Long childLeafCount;
	/**
	 * Privilege Enum Id
	 */
	@Getter
	@Setter
	private String privilegeEnumId;
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
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Template Data Resource Id
	 */
	@Getter
	@Setter
	private String templateDataResourceId;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Instance Of Content Id
	 */
	@Getter
	@Setter
	private String instanceOfContentId;
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Custom Method Id
	 */
	@Getter
	@Setter
	private String customMethodId;
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
	/**
	 * Content Name
	 */
	@Getter
	@Setter
	private String contentName;
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
	 * Decorator Content Id
	 */
	@Getter
	@Setter
	private String decoratorContentId;
	/**
	 * Child Branch Count
	 */
	@Getter
	@Setter
	private Long childBranchCount;
	/**
	 * Dr Data Resource Name
	 */
	@Getter
	@Setter
	private String drDataResourceName;
	/**
	 * Dr Survey Id
	 */
	@Getter
	@Setter
	private String drSurveyId;
	/**
	 * Dr Data Template Type Id
	 */
	@Getter
	@Setter
	private String drDataTemplateTypeId;
	/**
	 * Dr Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp drLastModifiedDate;
	/**
	 * Dr Mime Type Id
	 */
	@Getter
	@Setter
	private String drMimeTypeId;
	/**
	 * Dr Data Category Id
	 */
	@Getter
	@Setter
	private String drDataCategoryId;
	/**
	 * Dr Survey Response Id
	 */
	@Getter
	@Setter
	private String drSurveyResponseId;
	/**
	 * Dr Character Set Id
	 */
	@Getter
	@Setter
	private String drCharacterSetId;
	/**
	 * Dr Data Source Id
	 */
	@Getter
	@Setter
	private String drDataSourceId;
	/**
	 * Dr Last Modified By User Login
	 */
	@Getter
	@Setter
	private String drLastModifiedByUserLogin;
	/**
	 * Dr Created Date
	 */
	@Getter
	@Setter
	private Timestamp drCreatedDate;
	/**
	 * Dr Status Id
	 */
	@Getter
	@Setter
	private String drStatusId;
	/**
	 * Dr Locale String
	 */
	@Getter
	@Setter
	private String drLocaleString;
	/**
	 * Dr Related Detail Id
	 */
	@Getter
	@Setter
	private String drRelatedDetailId;
	/**
	 * Dr Data Resource Id
	 */
	@Getter
	@Setter
	private String drDataResourceId;
	/**
	 * Dr Is Public
	 */
	@Getter
	@Setter
	private String drIsPublic;
	/**
	 * Dr Object Info
	 */
	@Getter
	@Setter
	private String drObjectInfo;
	/**
	 * Dr Data Resource Type Id
	 */
	@Getter
	@Setter
	private String drDataResourceTypeId;
	/**
	 * Dr Created By User Login
	 */
	@Getter
	@Setter
	private String drCreatedByUserLogin;

	public ContentDataResourceView(GenericValue value) {
		ownerContentId = (String) value.get(FIELD_OWNER_CONTENT_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentTypeId = (String) value.get(FIELD_CONTENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		childLeafCount = (Long) value.get(FIELD_CHILD_LEAF_COUNT);
		privilegeEnumId = (String) value.get(FIELD_PRIVILEGE_ENUM_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		templateDataResourceId = (String) value
				.get(FIELD_TEMPLATE_DATA_RESOURCE_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		instanceOfContentId = (String) value.get(FIELD_INSTANCE_OF_CONTENT_ID);
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		customMethodId = (String) value.get(FIELD_CUSTOM_METHOD_ID);
		characterSetId = (String) value.get(FIELD_CHARACTER_SET_ID);
		contentName = (String) value.get(FIELD_CONTENT_NAME);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		localeString = (String) value.get(FIELD_LOCALE_STRING);
		decoratorContentId = (String) value.get(FIELD_DECORATOR_CONTENT_ID);
		childBranchCount = (Long) value.get(FIELD_CHILD_BRANCH_COUNT);
		drDataResourceName = (String) value.get(FIELD_DR_DATA_RESOURCE_NAME);
		drSurveyId = (String) value.get(FIELD_DR_SURVEY_ID);
		drDataTemplateTypeId = (String) value
				.get(FIELD_DR_DATA_TEMPLATE_TYPE_ID);
		drLastModifiedDate = (Timestamp) value.get(FIELD_DR_LAST_MODIFIED_DATE);
		drMimeTypeId = (String) value.get(FIELD_DR_MIME_TYPE_ID);
		drDataCategoryId = (String) value.get(FIELD_DR_DATA_CATEGORY_ID);
		drSurveyResponseId = (String) value.get(FIELD_DR_SURVEY_RESPONSE_ID);
		drCharacterSetId = (String) value.get(FIELD_DR_CHARACTER_SET_ID);
		drDataSourceId = (String) value.get(FIELD_DR_DATA_SOURCE_ID);
		drLastModifiedByUserLogin = (String) value
				.get(FIELD_DR_LAST_MODIFIED_BY_USER_LOGIN);
		drCreatedDate = (Timestamp) value.get(FIELD_DR_CREATED_DATE);
		drStatusId = (String) value.get(FIELD_DR_STATUS_ID);
		drLocaleString = (String) value.get(FIELD_DR_LOCALE_STRING);
		drRelatedDetailId = (String) value.get(FIELD_DR_RELATED_DETAIL_ID);
		drDataResourceId = (String) value.get(FIELD_DR_DATA_RESOURCE_ID);
		drIsPublic = (String) value.get(FIELD_DR_IS_PUBLIC);
		drObjectInfo = (String) value.get(FIELD_DR_OBJECT_INFO);
		drDataResourceTypeId = (String) value
				.get(FIELD_DR_DATA_RESOURCE_TYPE_ID);
		drCreatedByUserLogin = (String) value
				.get(FIELD_DR_CREATED_BY_USER_LOGIN);
	}

	public static ContentDataResourceView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentDataResourceView(value);
	}

	public static List<ContentDataResourceView> fromValues(
			List<GenericValue> values) {
		List<ContentDataResourceView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentDataResourceView(value));
		}
		return entities;
	}
}