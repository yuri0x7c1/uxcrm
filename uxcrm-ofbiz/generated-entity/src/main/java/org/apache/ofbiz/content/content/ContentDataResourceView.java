package org.apache.ofbiz.content.content;

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
public class ContentDataResourceView implements Serializable {

	public static final long serialVersionUID = 3640940755651400704L;
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

	public enum Fields {
		ownerContentId, contentId, contentTypeId, description, mimeTypeId, childLeafCount, privilegeEnumId, dataSourceId, lastModifiedByUserLogin, dataResourceId, createdByUserLogin, templateDataResourceId, lastModifiedDate, instanceOfContentId, serviceName, customMethodId, characterSetId, contentName, createdDate, statusId, localeString, decoratorContentId, childBranchCount, drDataResourceName, drSurveyId, drDataTemplateTypeId, drLastModifiedDate, drMimeTypeId, drDataCategoryId, drSurveyResponseId, drCharacterSetId, drDataSourceId, drLastModifiedByUserLogin, drCreatedDate, drStatusId, drLocaleString, drRelatedDetailId, drDataResourceId, drIsPublic, drObjectInfo, drDataResourceTypeId, drCreatedByUserLogin
	}

	public ContentDataResourceView(GenericValue value) {
		ownerContentId = (String) value.get(Fields.ownerContentId.name());
		contentId = (String) value.get(Fields.contentId.name());
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		description = (String) value.get(Fields.description.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		childLeafCount = (Long) value.get(Fields.childLeafCount.name());
		privilegeEnumId = (String) value.get(Fields.privilegeEnumId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		templateDataResourceId = (String) value
				.get(Fields.templateDataResourceId.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		instanceOfContentId = (String) value.get(Fields.instanceOfContentId
				.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		customMethodId = (String) value.get(Fields.customMethodId.name());
		characterSetId = (String) value.get(Fields.characterSetId.name());
		contentName = (String) value.get(Fields.contentName.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		localeString = (String) value.get(Fields.localeString.name());
		decoratorContentId = (String) value.get(Fields.decoratorContentId
				.name());
		childBranchCount = (Long) value.get(Fields.childBranchCount.name());
		drDataResourceName = (String) value.get(Fields.drDataResourceName
				.name());
		drSurveyId = (String) value.get(Fields.drSurveyId.name());
		drDataTemplateTypeId = (String) value.get(Fields.drDataTemplateTypeId
				.name());
		drLastModifiedDate = (Timestamp) value.get(Fields.drLastModifiedDate
				.name());
		drMimeTypeId = (String) value.get(Fields.drMimeTypeId.name());
		drDataCategoryId = (String) value.get(Fields.drDataCategoryId.name());
		drSurveyResponseId = (String) value.get(Fields.drSurveyResponseId
				.name());
		drCharacterSetId = (String) value.get(Fields.drCharacterSetId.name());
		drDataSourceId = (String) value.get(Fields.drDataSourceId.name());
		drLastModifiedByUserLogin = (String) value
				.get(Fields.drLastModifiedByUserLogin.name());
		drCreatedDate = (Timestamp) value.get(Fields.drCreatedDate.name());
		drStatusId = (String) value.get(Fields.drStatusId.name());
		drLocaleString = (String) value.get(Fields.drLocaleString.name());
		drRelatedDetailId = (String) value.get(Fields.drRelatedDetailId.name());
		drDataResourceId = (String) value.get(Fields.drDataResourceId.name());
		drIsPublic = (String) value.get(Fields.drIsPublic.name());
		drObjectInfo = (String) value.get(Fields.drObjectInfo.name());
		drDataResourceTypeId = (String) value.get(Fields.drDataResourceTypeId
				.name());
		drCreatedByUserLogin = (String) value.get(Fields.drCreatedByUserLogin
				.name());
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