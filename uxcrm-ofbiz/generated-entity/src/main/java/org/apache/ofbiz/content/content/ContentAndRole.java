package org.apache.ofbiz.content.content;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content And Role
 */
public class ContentAndRole implements Serializable {

	public static final long serialVersionUID = 605953283285838848L;
	public static final String NAME = "ContentAndRole";
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		ownerContentId, contentId, contentTypeId, description, mimeTypeId, childLeafCount, privilegeEnumId, dataSourceId, lastModifiedByUserLogin, dataResourceId, createdByUserLogin, templateDataResourceId, lastModifiedDate, instanceOfContentId, serviceName, customMethodId, characterSetId, contentName, createdDate, statusId, localeString, decoratorContentId, childBranchCount, fromDate, roleTypeId, partyId, thruDate
	}

	public ContentAndRole(GenericValue value) {
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
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ContentAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAndRole(value);
	}

	public static List<ContentAndRole> fromValues(List<GenericValue> values) {
		List<ContentAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAndRole(value));
		}
		return entities;
	}
}