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
 * Portal Page And User Login
 */
@FieldNameConstants
public class PortalPageAndUserLogin implements Serializable {

	public static final long serialVersionUID = 6797229688015583232L;
	public static final String NAME = "PortalPageAndUserLogin";
	/**
	 * Portal Page Id
	 */
	@Getter
	@Setter
	private String portalPageId;
	/**
	 * Security Group Id
	 */
	@Getter
	@Setter
	private String securityGroupId;
	/**
	 * Parent Portal Page Id
	 */
	@Getter
	@Setter
	private String parentPortalPageId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
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

	public PortalPageAndUserLogin(GenericValue value) {
		portalPageId = (String) value.get(FIELD_PORTAL_PAGE_ID);
		securityGroupId = (String) value.get(FIELD_SECURITY_GROUP_ID);
		parentPortalPageId = (String) value.get(FIELD_PARENT_PORTAL_PAGE_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static PortalPageAndUserLogin fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PortalPageAndUserLogin(value);
	}

	public static List<PortalPageAndUserLogin> fromValues(
			List<GenericValue> values) {
		List<PortalPageAndUserLogin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PortalPageAndUserLogin(value));
		}
		return entities;
	}
}