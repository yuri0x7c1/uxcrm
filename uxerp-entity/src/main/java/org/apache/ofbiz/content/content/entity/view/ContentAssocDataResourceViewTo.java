package org.apache.ofbiz.content.content.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc Data Resource View To
 */
public class ContentAssocDataResourceViewTo implements Serializable {

	public static final long serialVersionUID = 1549834733922045952L;
	public static final String NAME = "ContentAssocDataResourceViewTo";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Id To
	 */
	@Getter
	@Setter
	private String contentIdTo;
	/**
	 * Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String contentAssocTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Content Assoc Predicate Id
	 */
	@Getter
	@Setter
	private String contentAssocPredicateId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Map Key
	 */
	@Getter
	@Setter
	private String mapKey;
	/**
	 * Upper Coordinate
	 */
	@Getter
	@Setter
	private Long upperCoordinate;
	/**
	 * Left Coordinate
	 */
	@Getter
	@Setter
	private Long leftCoordinate;
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
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Owner Content Id
	 */
	@Getter
	@Setter
	private String ownerContentId;
	/**
	 * Decorator Content Id
	 */
	@Getter
	@Setter
	private String decoratorContentId;
	/**
	 * Instance Of Content Id
	 */
	@Getter
	@Setter
	private String instanceOfContentId;
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Template Data Resource Id
	 */
	@Getter
	@Setter
	private String templateDataResourceId;
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
	 * Content Name
	 */
	@Getter
	@Setter
	private String contentName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Child Leaf Count
	 */
	@Getter
	@Setter
	private Long childLeafCount;
	/**
	 * Child Branch Count
	 */
	@Getter
	@Setter
	private Long childBranchCount;
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
	 * Data Resource Name
	 */
	@Getter
	@Setter
	private String dataResourceName;
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

	public enum Fields {
		contentId, contentIdTo, contentAssocTypeId, fromDate, thruDate, contentAssocPredicateId, dataSourceId, sequenceNum, mapKey, upperCoordinate, leftCoordinate, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, contentTypeId, ownerContentId, decoratorContentId, instanceOfContentId, dataResourceId, templateDataResourceId, statusId, privilegeEnumId, serviceName, customMethodId, contentName, description, localeString, mimeTypeId, characterSetId, childLeafCount, childBranchCount, dataResourceTypeId, dataTemplateTypeId, dataCategoryId, dataResourceName, objectInfo, surveyId, surveyResponseId, relatedDetailId, isPublic
	}

	public ContentAssocDataResourceViewTo(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentIdTo = (String) value.get(Fields.contentIdTo.name());
		contentAssocTypeId = (String) value.get(Fields.contentAssocTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		contentAssocPredicateId = (String) value
				.get(Fields.contentAssocPredicateId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		mapKey = (String) value.get(Fields.mapKey.name());
		upperCoordinate = (Long) value.get(Fields.upperCoordinate.name());
		leftCoordinate = (Long) value.get(Fields.leftCoordinate.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		ownerContentId = (String) value.get(Fields.ownerContentId.name());
		decoratorContentId = (String) value.get(Fields.decoratorContentId
				.name());
		instanceOfContentId = (String) value.get(Fields.instanceOfContentId
				.name());
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		templateDataResourceId = (String) value
				.get(Fields.templateDataResourceId.name());
		statusId = (String) value.get(Fields.statusId.name());
		privilegeEnumId = (String) value.get(Fields.privilegeEnumId.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		customMethodId = (String) value.get(Fields.customMethodId.name());
		contentName = (String) value.get(Fields.contentName.name());
		description = (String) value.get(Fields.description.name());
		localeString = (String) value.get(Fields.localeString.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		characterSetId = (String) value.get(Fields.characterSetId.name());
		childLeafCount = (Long) value.get(Fields.childLeafCount.name());
		childBranchCount = (Long) value.get(Fields.childBranchCount.name());
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
				.name());
		dataTemplateTypeId = (String) value.get(Fields.dataTemplateTypeId
				.name());
		dataCategoryId = (String) value.get(Fields.dataCategoryId.name());
		dataResourceName = (String) value.get(Fields.dataResourceName.name());
		objectInfo = (String) value.get(Fields.objectInfo.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		relatedDetailId = (String) value.get(Fields.relatedDetailId.name());
		isPublic = (String) value.get(Fields.isPublic.name());
	}

	public static ContentAssocDataResourceViewTo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocDataResourceViewTo(value);
	}

	public static List<ContentAssocDataResourceViewTo> fromValues(
			List<GenericValue> values) {
		List<ContentAssocDataResourceViewTo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocDataResourceViewTo(value));
		}
		return entities;
	}
}