package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Web Site Role
 */
public class WebSiteRole implements Serializable {

	public static final long serialVersionUID = 1721232890328809472L;
	public static final String NAME = "WebSiteRole";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
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
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		partyId, roleTypeId, webSiteId, fromDate, thruDate, sequenceNum
	}

	public WebSiteRole(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static WebSiteRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WebSiteRole(value);
	}

	public static List<WebSiteRole> fromValues(List<GenericValue> values) {
		List<WebSiteRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WebSiteRole(value));
		}
		return entities;
	}
}