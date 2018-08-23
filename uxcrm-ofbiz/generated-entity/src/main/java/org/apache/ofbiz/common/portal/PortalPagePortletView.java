package org.apache.ofbiz.common.portal;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page Portlet View
 */
@FieldNameConstants
public class PortalPagePortletView implements Serializable {

	public static final long serialVersionUID = 3523626929493536768L;
	public static final String NAME = "PortalPagePortletView";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Portlet Seq Id
	 */
	@Getter
	@Setter
	private String portletSeqId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Screen Name
	 */
	@Getter
	@Setter
	private String screenName;
	/**
	 * Screenshot
	 */
	@Getter
	@Setter
	private String screenshot;
	/**
	 * Security Service Name
	 */
	@Getter
	@Setter
	private String securityServiceName;
	/**
	 * Portlet Name
	 */
	@Getter
	@Setter
	private String portletName;
	/**
	 * Screen Location
	 */
	@Getter
	@Setter
	private String screenLocation;
	/**
	 * Edit Form Location
	 */
	@Getter
	@Setter
	private String editFormLocation;
	/**
	 * Security Main Action
	 */
	@Getter
	@Setter
	private String securityMainAction;
	/**
	 * Edit Form Name
	 */
	@Getter
	@Setter
	private String editFormName;

	public PortalPagePortletView(GenericValue value) {
		portalPageId = (String) value.get(FIELD_PORTAL_PAGE_ID);
		portletSeqId = (String) value.get(FIELD_PORTLET_SEQ_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		portalPortletId = (String) value.get(FIELD_PORTAL_PORTLET_ID);
		columnSeqId = (String) value.get(FIELD_COLUMN_SEQ_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		screenName = (String) value.get(FIELD_SCREEN_NAME);
		screenshot = (String) value.get(FIELD_SCREENSHOT);
		securityServiceName = (String) value.get(FIELD_SECURITY_SERVICE_NAME);
		portletName = (String) value.get(FIELD_PORTLET_NAME);
		screenLocation = (String) value.get(FIELD_SCREEN_LOCATION);
		editFormLocation = (String) value.get(FIELD_EDIT_FORM_LOCATION);
		securityMainAction = (String) value.get(FIELD_SECURITY_MAIN_ACTION);
		editFormName = (String) value.get(FIELD_EDIT_FORM_NAME);
	}

	public static PortalPagePortletView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPagePortletView(value);
	}

	public static List<PortalPagePortletView> fromValues(
			List<GenericValue> values) {
		List<PortalPagePortletView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPagePortletView(value));
		}
		return entities;
	}
}