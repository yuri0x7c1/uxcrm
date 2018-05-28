package org.apache.ofbiz.common.portal;

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

	public static final long serialVersionUID = 506307089895691264L;
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

	public enum Fields {
		portalPageId, portletSeqId, sequenceNum, portalPortletId, columnSeqId, description, screenName, screenshot, securityServiceName, portletName, screenLocation, editFormLocation, securityMainAction, editFormName
	}

	public PortalPagePortletView(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		portletSeqId = (String) value.get(Fields.portletSeqId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
		columnSeqId = (String) value.get(Fields.columnSeqId.name());
		description = (String) value.get(Fields.description.name());
		screenName = (String) value.get(Fields.screenName.name());
		screenshot = (String) value.get(Fields.screenshot.name());
		securityServiceName = (String) value.get(Fields.securityServiceName
				.name());
		portletName = (String) value.get(Fields.portletName.name());
		screenLocation = (String) value.get(Fields.screenLocation.name());
		editFormLocation = (String) value.get(Fields.editFormLocation.name());
		securityMainAction = (String) value.get(Fields.securityMainAction
				.name());
		editFormName = (String) value.get(Fields.editFormName.name());
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