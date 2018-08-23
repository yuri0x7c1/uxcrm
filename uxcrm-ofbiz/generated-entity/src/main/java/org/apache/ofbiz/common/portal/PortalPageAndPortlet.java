package org.apache.ofbiz.common.portal;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page And Portlet
 */
@FieldNameConstants
public class PortalPageAndPortlet implements Serializable {

	public static final long serialVersionUID = 9194137207511826432L;
	public static final String NAME = "PortalPageAndPortlet";
	/**
	 * Portlet Sequence Num
	 */
	@Getter
	@Setter
	private Long portletSequenceNum;
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Original Portal Page Id
	 */
	@Getter
	@Setter
	private String originalPortalPageId;
	/**
	 * Parent Portal Page Id
	 */
	@Getter
	@Setter
	private String parentPortalPageId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Help Content Id
	 */
	@Getter
	@Setter
	private String helpContentId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Owner User Login Id
	 */
	@Getter
	@Setter
	private String ownerUserLoginId;
	/**
	 * Security Group Id
	 */
	@Getter
	@Setter
	private String securityGroupId;
	/**
	 * Portal Page Name
	 */
	@Getter
	@Setter
	private String portalPageName;
	/**
	 * Portlet Seq Id
	 */
	@Getter
	@Setter
	private String portletSeqId;
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Column Seq Id
	 */
	@Getter
	@Setter
	private String columnSeqId;

	public PortalPageAndPortlet(GenericValue value) {
		portletSequenceNum = (Long) value.get(FIELD_PORTLET_SEQUENCE_NUM);
		portalPageId = (String) value.get(FIELD_PORTAL_PAGE_ID);
		originalPortalPageId = (String) value
				.get(FIELD_ORIGINAL_PORTAL_PAGE_ID);
		parentPortalPageId = (String) value.get(FIELD_PARENT_PORTAL_PAGE_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		helpContentId = (String) value.get(FIELD_HELP_CONTENT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		ownerUserLoginId = (String) value.get(FIELD_OWNER_USER_LOGIN_ID);
		securityGroupId = (String) value.get(FIELD_SECURITY_GROUP_ID);
		portalPageName = (String) value.get(FIELD_PORTAL_PAGE_NAME);
		portletSeqId = (String) value.get(FIELD_PORTLET_SEQ_ID);
		portalPortletId = (String) value.get(FIELD_PORTAL_PORTLET_ID);
		columnSeqId = (String) value.get(FIELD_COLUMN_SEQ_ID);
	}

	public static PortalPageAndPortlet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPageAndPortlet(value);
	}

	public static List<PortalPageAndPortlet> fromValues(
			List<GenericValue> values) {
		List<PortalPageAndPortlet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPageAndPortlet(value));
		}
		return entities;
	}
}