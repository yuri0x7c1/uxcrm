package org.apache.ofbiz.common.portal;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PortalPortlet implements Serializable {

	public static final long serialVersionUID = 7343198030940009472L;
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

	public PortalPortlet(GenericValue value) {
		portalPortletId = (String) value.get(FIELD_PORTAL_PORTLET_ID);
		portletName = (String) value.get(FIELD_PORTLET_NAME);
		screenName = (String) value.get(FIELD_SCREEN_NAME);
		screenLocation = (String) value.get(FIELD_SCREEN_LOCATION);
		editFormName = (String) value.get(FIELD_EDIT_FORM_NAME);
		editFormLocation = (String) value.get(FIELD_EDIT_FORM_LOCATION);
		description = (String) value.get(FIELD_DESCRIPTION);
		screenshot = (String) value.get(FIELD_SCREENSHOT);
		securityServiceName = (String) value.get(FIELD_SECURITY_SERVICE_NAME);
		securityMainAction = (String) value.get(FIELD_SECURITY_MAIN_ACTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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