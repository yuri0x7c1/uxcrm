package org.apache.ofbiz.common.portal.entity.view;

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
public class PortalPageAndUserLogin implements Serializable {

	public static final long serialVersionUID = 9011889744241868800L;
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

	public enum Fields {
		portalPageId, securityGroupId, parentPortalPageId, userLoginId, fromDate, thruDate
	}

	public PortalPageAndUserLogin(GenericValue value) {
		portalPageId = (String) value.get(Fields.portalPageId.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		parentPortalPageId = (String) value.get(Fields.parentPortalPageId
				.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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