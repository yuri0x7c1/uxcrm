package org.apache.ofbiz.common.portal.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Page Portlet View
 */
public class PortalPagePortletView implements Serializable {

	public static final long serialVersionUID = 5195805307430563840L;
	public static final String NAME = "PortalPagePortletView";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
	/**
	 * Portlet Seq Id
	 */
	@Getter
	@Setter
	private String portletSeqId;
	/**
	 * Column Seq Id
	 */
	@Getter
	@Setter
	private String columnSeqId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Portlet Name
	 */
	@Getter
	@Setter
	private String portletName;
	/**
	 * Screen Name
	 */
	@Getter
	@Setter
	private String screenName;
	/**
	 * Screen Location
	 */
	@Getter
	@Setter
	private String screenLocation;
	/**
	 * Edit Form Name
	 */
	@Getter
	@Setter
	private String editFormName;
	/**
	 * Edit Form Location
	 */
	@Getter
	@Setter
	private String editFormLocation;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Security Main Action
	 */
	@Getter
	@Setter
	private String securityMainAction;

	public enum Fields {
		portalPageId, portalPortletId, portletSeqId, columnSeqId, sequenceNum, portletName, screenName, screenLocation, editFormName, editFormLocation, description, screenshot, securityServiceName, securityMainAction
	}

	public PortalPagePortletView(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		columnSeqId = (String) value.get(Fields.columnSeqId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		portletName = (String) value.get(Fields.portletName.name());
		screenName = (String) value.get(Fields.screenName.name());
		screenLocation = (String) value.get(Fields.screenLocation.name());
		editFormName = (String) value.get(Fields.editFormName.name());
		editFormLocation = (String) value.get(Fields.editFormLocation.name());
		description = (String) value.get(Fields.description.name());
		screenshot = (String) value.get(Fields.screenshot.name());
		securityServiceName = (String) value.get(Fields.securityServiceName
				.name());
		securityMainAction = (String) value.get(Fields.securityMainAction
				.name());
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