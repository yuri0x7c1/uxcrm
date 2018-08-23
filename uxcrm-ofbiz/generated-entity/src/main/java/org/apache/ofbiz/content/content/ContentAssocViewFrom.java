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
 * Content Assoc View From
 */
@FieldNameConstants
public class ContentAssocViewFrom implements Serializable {

	public static final long serialVersionUID = 6433452471091207168L;
	public static final String NAME = "ContentAssocViewFrom";
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

	public ContentAssocViewFrom(GenericValue value) {
		contentIdStart = (String) value.get(FIELD_CONTENT_ID_START);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
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
		caSequenceNum = (Long) value.get(FIELD_CA_SEQUENCE_NUM);
		caLastModifiedDate = (Timestamp) value.get(FIELD_CA_LAST_MODIFIED_DATE);
		caContentIdTo = (String) value.get(FIELD_CA_CONTENT_ID_TO);
		caUpperCoordinate = (Long) value.get(FIELD_CA_UPPER_COORDINATE);
		caLeftCoordinate = (Long) value.get(FIELD_CA_LEFT_COORDINATE);
		caContentId = (String) value.get(FIELD_CA_CONTENT_ID);
		caMapKey = (String) value.get(FIELD_CA_MAP_KEY);
		caThruDate = (Timestamp) value.get(FIELD_CA_THRU_DATE);
		caFromDate = (Timestamp) value.get(FIELD_CA_FROM_DATE);
		caContentAssocPredicateId = (String) value
				.get(FIELD_CA_CONTENT_ASSOC_PREDICATE_ID);
		caDataSourceId = (String) value.get(FIELD_CA_DATA_SOURCE_ID);
		caLastModifiedByUserLogin = (String) value
				.get(FIELD_CA_LAST_MODIFIED_BY_USER_LOGIN);
		caCreatedDate = (Timestamp) value.get(FIELD_CA_CREATED_DATE);
		caContentAssocTypeId = (String) value
				.get(FIELD_CA_CONTENT_ASSOC_TYPE_ID);
		caCreatedByUserLogin = (String) value
				.get(FIELD_CA_CREATED_BY_USER_LOGIN);
	}

	public static ContentAssocViewFrom fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocViewFrom(value);
	}

	public static List<ContentAssocViewFrom> fromValues(
			List<GenericValue> values) {
		List<ContentAssocViewFrom> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocViewFrom(value));
		}
		return entities;
	}
}