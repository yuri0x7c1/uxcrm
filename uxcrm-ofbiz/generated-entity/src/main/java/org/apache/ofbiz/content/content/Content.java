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
 * Content
 */
@FieldNameConstants
public class Content implements Serializable {

	public static final long serialVersionUID = 3996778039004843008L;
	public static final String NAME = "Content";
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

	public Content(GenericValue value) {
		contentId = (String) value.get(FIELD_CONTENT_ID);
		contentTypeId = (String) value.get(FIELD_CONTENT_TYPE_ID);
		ownerContentId = (String) value.get(FIELD_OWNER_CONTENT_ID);
		decoratorContentId = (String) value.get(FIELD_DECORATOR_CONTENT_ID);
		instanceOfContentId = (String) value.get(FIELD_INSTANCE_OF_CONTENT_ID);
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		templateDataResourceId = (String) value
				.get(FIELD_TEMPLATE_DATA_RESOURCE_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		privilegeEnumId = (String) value.get(FIELD_PRIVILEGE_ENUM_ID);
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		customMethodId = (String) value.get(FIELD_CUSTOM_METHOD_ID);
		contentName = (String) value.get(FIELD_CONTENT_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		localeString = (String) value.get(FIELD_LOCALE_STRING);
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		characterSetId = (String) value.get(FIELD_CHARACTER_SET_ID);
		childLeafCount = (Long) value.get(FIELD_CHILD_LEAF_COUNT);
		childBranchCount = (Long) value.get(FIELD_CHILD_BRANCH_COUNT);
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

	public static Content fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Content(value);
	}

	public static List<Content> fromValues(List<GenericValue> values) {
		List<Content> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Content(value));
		}
		return entities;
	}
}