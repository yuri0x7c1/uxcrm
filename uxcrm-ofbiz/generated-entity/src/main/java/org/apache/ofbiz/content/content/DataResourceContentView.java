package org.apache.ofbiz.content.content;

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
public class DataResourceContentView implements Serializable {

	public static final long serialVersionUID = 4609945621801312256L;
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

	public enum Fields {
		dataResourceName, surveyId, dataTemplateTypeId, lastModifiedDate, mimeTypeId, dataCategoryId, surveyResponseId, characterSetId, dataSourceId, lastModifiedByUserLogin, createdDate, statusId, localeString, relatedDetailId, dataResourceId, isPublic, objectInfo, dataResourceTypeId, createdByUserLogin, coOwnerContentId, coContentId, coContentTypeId, coDescription, coMimeTypeId, coChildLeafCount, coPrivilegeEnumId, coDataSourceId, coLastModifiedByUserLogin, coDataResourceId, coCreatedByUserLogin, coTemplateDataResourceId, coLastModifiedDate, coInstanceOfContentId, coServiceName, coCustomMethodId, coCharacterSetId, coContentName, coCreatedDate, coStatusId, coLocaleString, coDecoratorContentId, coChildBranchCount
	}

	public DataResourceContentView(GenericValue value) {
		dataResourceName = (String) value.get(Fields.dataResourceName.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		dataTemplateTypeId = (String) value.get(Fields.dataTemplateTypeId
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		dataCategoryId = (String) value.get(Fields.dataCategoryId.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		characterSetId = (String) value.get(Fields.characterSetId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		localeString = (String) value.get(Fields.localeString.name());
		relatedDetailId = (String) value.get(Fields.relatedDetailId.name());
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		isPublic = (String) value.get(Fields.isPublic.name());
		objectInfo = (String) value.get(Fields.objectInfo.name());
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
				.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		coOwnerContentId = (String) value.get(Fields.coOwnerContentId.name());
		coContentId = (String) value.get(Fields.coContentId.name());
		coContentTypeId = (String) value.get(Fields.coContentTypeId.name());
		coDescription = (String) value.get(Fields.coDescription.name());
		coMimeTypeId = (String) value.get(Fields.coMimeTypeId.name());
		coChildLeafCount = (Long) value.get(Fields.coChildLeafCount.name());
		coPrivilegeEnumId = (String) value.get(Fields.coPrivilegeEnumId.name());
		coDataSourceId = (String) value.get(Fields.coDataSourceId.name());
		coLastModifiedByUserLogin = (String) value
				.get(Fields.coLastModifiedByUserLogin.name());
		coDataResourceId = (String) value.get(Fields.coDataResourceId.name());
		coCreatedByUserLogin = (String) value.get(Fields.coCreatedByUserLogin
				.name());
		coTemplateDataResourceId = (String) value
				.get(Fields.coTemplateDataResourceId.name());
		coLastModifiedDate = (Timestamp) value.get(Fields.coLastModifiedDate
				.name());
		coInstanceOfContentId = (String) value.get(Fields.coInstanceOfContentId
				.name());
		coServiceName = (String) value.get(Fields.coServiceName.name());
		coCustomMethodId = (String) value.get(Fields.coCustomMethodId.name());
		coCharacterSetId = (String) value.get(Fields.coCharacterSetId.name());
		coContentName = (String) value.get(Fields.coContentName.name());
		coCreatedDate = (Timestamp) value.get(Fields.coCreatedDate.name());
		coStatusId = (String) value.get(Fields.coStatusId.name());
		coLocaleString = (String) value.get(Fields.coLocaleString.name());
		coDecoratorContentId = (String) value.get(Fields.coDecoratorContentId
				.name());
		coChildBranchCount = (Long) value.get(Fields.coChildBranchCount.name());
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