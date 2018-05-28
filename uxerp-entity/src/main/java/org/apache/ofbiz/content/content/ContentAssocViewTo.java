package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc View To
 */
public class ContentAssocViewTo implements Serializable {

	public static final long serialVersionUID = 1477939415248303104L;
	public static final String NAME = "ContentAssocViewTo";
	/**
	 * Content Id Start
	 */
	@Getter
	@Setter
	private String contentIdStart;
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
	 * Ca Sequence Num
	 */
	@Getter
	@Setter
	private Long caSequenceNum;
	/**
	 * Ca Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp caLastModifiedDate;
	/**
	 * Ca Content Id To
	 */
	@Getter
	@Setter
	private String caContentIdTo;
	/**
	 * Ca Upper Coordinate
	 */
	@Getter
	@Setter
	private Long caUpperCoordinate;
	/**
	 * Ca Left Coordinate
	 */
	@Getter
	@Setter
	private Long caLeftCoordinate;
	/**
	 * Ca Content Id
	 */
	@Getter
	@Setter
	private String caContentId;
	/**
	 * Ca Map Key
	 */
	@Getter
	@Setter
	private String caMapKey;
	/**
	 * Ca Thru Date
	 */
	@Getter
	@Setter
	private Timestamp caThruDate;
	/**
	 * Ca From Date
	 */
	@Getter
	@Setter
	private Timestamp caFromDate;
	/**
	 * Ca Content Assoc Predicate Id
	 */
	@Getter
	@Setter
	private String caContentAssocPredicateId;
	/**
	 * Ca Data Source Id
	 */
	@Getter
	@Setter
	private String caDataSourceId;
	/**
	 * Ca Last Modified By User Login
	 */
	@Getter
	@Setter
	private String caLastModifiedByUserLogin;
	/**
	 * Ca Created Date
	 */
	@Getter
	@Setter
	private Timestamp caCreatedDate;
	/**
	 * Ca Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String caContentAssocTypeId;
	/**
	 * Ca Created By User Login
	 */
	@Getter
	@Setter
	private String caCreatedByUserLogin;

	public enum Fields {
		contentIdStart, fromDate, thruDate, ownerContentId, contentId, contentTypeId, description, mimeTypeId, childLeafCount, privilegeEnumId, dataSourceId, lastModifiedByUserLogin, dataResourceId, createdByUserLogin, templateDataResourceId, lastModifiedDate, instanceOfContentId, serviceName, customMethodId, characterSetId, contentName, createdDate, statusId, localeString, decoratorContentId, childBranchCount, caSequenceNum, caLastModifiedDate, caContentIdTo, caUpperCoordinate, caLeftCoordinate, caContentId, caMapKey, caThruDate, caFromDate, caContentAssocPredicateId, caDataSourceId, caLastModifiedByUserLogin, caCreatedDate, caContentAssocTypeId, caCreatedByUserLogin
	}

	public ContentAssocViewTo(GenericValue value) {
		contentIdStart = (String) value.get(Fields.contentIdStart.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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
		caSequenceNum = (Long) value.get(Fields.caSequenceNum.name());
		caLastModifiedDate = (Timestamp) value.get(Fields.caLastModifiedDate
				.name());
		caContentIdTo = (String) value.get(Fields.caContentIdTo.name());
		caUpperCoordinate = (Long) value.get(Fields.caUpperCoordinate.name());
		caLeftCoordinate = (Long) value.get(Fields.caLeftCoordinate.name());
		caContentId = (String) value.get(Fields.caContentId.name());
		caMapKey = (String) value.get(Fields.caMapKey.name());
		caThruDate = (Timestamp) value.get(Fields.caThruDate.name());
		caFromDate = (Timestamp) value.get(Fields.caFromDate.name());
		caContentAssocPredicateId = (String) value
				.get(Fields.caContentAssocPredicateId.name());
		caDataSourceId = (String) value.get(Fields.caDataSourceId.name());
		caLastModifiedByUserLogin = (String) value
				.get(Fields.caLastModifiedByUserLogin.name());
		caCreatedDate = (Timestamp) value.get(Fields.caCreatedDate.name());
		caContentAssocTypeId = (String) value.get(Fields.caContentAssocTypeId
				.name());
		caCreatedByUserLogin = (String) value.get(Fields.caCreatedByUserLogin
				.name());
	}

	public static ContentAssocViewTo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocViewTo(value);
	}

	public static List<ContentAssocViewTo> fromValues(List<GenericValue> values) {
		List<ContentAssocViewTo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocViewTo(value));
		}
		return entities;
	}
}