package org.apache.ofbiz.webapp.visit;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Visit
 */
public class Visit implements Serializable {

	public static final long serialVersionUID = 1014085928014504960L;
	public static final String NAME = "Visit";
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Visitor Id
	 */
	@Getter
	@Setter
	private String visitorId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * User Created
	 */
	@Getter
	@Setter
	private String userCreated;
	/**
	 * Session Id
	 */
	@Getter
	@Setter
	private String sessionId;
	/**
	 * Server Ip Address
	 */
	@Getter
	@Setter
	private String serverIpAddress;
	/**
	 * Server Host Name
	 */
	@Getter
	@Setter
	private String serverHostName;
	/**
	 * Webapp Name
	 */
	@Getter
	@Setter
	private String webappName;
	/**
	 * Initial Locale
	 */
	@Getter
	@Setter
	private String initialLocale;
	/**
	 * Initial Request
	 */
	@Getter
	@Setter
	private String initialRequest;
	/**
	 * Initial Referrer
	 */
	@Getter
	@Setter
	private String initialReferrer;
	/**
	 * Initial User Agent
	 */
	@Getter
	@Setter
	private String initialUserAgent;
	/**
	 * User Agent Id
	 */
	@Getter
	@Setter
	private String userAgentId;
	/**
	 * Client Ip Address
	 */
	@Getter
	@Setter
	private String clientIpAddress;
	/**
	 * Client Host Name
	 */
	@Getter
	@Setter
	private String clientHostName;
	/**
	 * Client User
	 */
	@Getter
	@Setter
	private String clientUser;
	/**
	 * Client Ip Isp Name
	 */
	@Getter
	@Setter
	private String clientIpIspName;
	/**
	 * Client Ip Postal Code
	 */
	@Getter
	@Setter
	private String clientIpPostalCode;
	/**
	 * Cookie
	 */
	@Getter
	@Setter
	private String cookie;
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
	 * Client Ip State Prov Geo Id
	 */
	@Getter
	@Setter
	private String clientIpStateProvGeoId;
	/**
	 * Client Ip Country Geo Id
	 */
	@Getter
	@Setter
	private String clientIpCountryGeoId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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

	public enum Fields {
		visitId, visitorId, userLoginId, userCreated, sessionId, serverIpAddress, serverHostName, webappName, initialLocale, initialRequest, initialReferrer, initialUserAgent, userAgentId, clientIpAddress, clientHostName, clientUser, clientIpIspName, clientIpPostalCode, cookie, fromDate, thruDate, clientIpStateProvGeoId, clientIpCountryGeoId, contactMechId, partyId, roleTypeId
	}

	public Visit(GenericValue value) {
		visitId = (String) value.get(Fields.visitId.name());
		visitorId = (String) value.get(Fields.visitorId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		userCreated = (String) value.get(Fields.userCreated.name());
		sessionId = (String) value.get(Fields.sessionId.name());
		serverIpAddress = (String) value.get(Fields.serverIpAddress.name());
		serverHostName = (String) value.get(Fields.serverHostName.name());
		webappName = (String) value.get(Fields.webappName.name());
		initialLocale = (String) value.get(Fields.initialLocale.name());
		initialRequest = (String) value.get(Fields.initialRequest.name());
		initialReferrer = (String) value.get(Fields.initialReferrer.name());
		initialUserAgent = (String) value.get(Fields.initialUserAgent.name());
		userAgentId = (String) value.get(Fields.userAgentId.name());
		clientIpAddress = (String) value.get(Fields.clientIpAddress.name());
		clientHostName = (String) value.get(Fields.clientHostName.name());
		clientUser = (String) value.get(Fields.clientUser.name());
		clientIpIspName = (String) value.get(Fields.clientIpIspName.name());
		clientIpPostalCode = (String) value.get(Fields.clientIpPostalCode
				.name());
		cookie = (String) value.get(Fields.cookie.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		clientIpStateProvGeoId = (String) value
				.get(Fields.clientIpStateProvGeoId.name());
		clientIpCountryGeoId = (String) value.get(Fields.clientIpCountryGeoId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static Visit fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Visit(value);
	}

	public static List<Visit> fromValues(List<GenericValue> values) {
		List<Visit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Visit(value));
		}
		return entities;
	}
}