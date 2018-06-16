package org.apache.ofbiz.common.portal;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Portal Portlet
 */
public class PortalPortlet implements Serializable {

	public static final long serialVersionUID = 1881647759272812544L;
	public static final String NAME = "PortalPortlet";
	/**
	 * Portal Portlet Id
	 */
	@Getter
	@Setter
	private String portalPortletId;
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

	public enum Fields {
		portalPortletId, portletName, screenName, screenLocation, editFormName, editFormLocation, description, screenshot, securityServiceName, securityMainAction, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PortalPortlet(GenericValue value) {
		portalPortletId = (String) value.get(Fields.portalPortletId.name());
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PortalPortlet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPortlet(value);
	}

	public static List<PortalPortlet> fromValues(List<GenericValue> values) {
		List<PortalPortlet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPortlet(value));
		}
		return entities;
	}
}