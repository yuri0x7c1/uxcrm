package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Visit implements Serializable {

	public static final long serialVersionUID = 2095145004269016064L;
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

	public Visit(GenericValue value) {
		visitId = (String) value.get(FIELD_VISIT_ID);
		visitorId = (String) value.get(FIELD_VISITOR_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		userCreated = (String) value.get(FIELD_USER_CREATED);
		sessionId = (String) value.get(FIELD_SESSION_ID);
		serverIpAddress = (String) value.get(FIELD_SERVER_IP_ADDRESS);
		serverHostName = (String) value.get(FIELD_SERVER_HOST_NAME);
		webappName = (String) value.get(FIELD_WEBAPP_NAME);
		initialLocale = (String) value.get(FIELD_INITIAL_LOCALE);
		initialRequest = (String) value.get(FIELD_INITIAL_REQUEST);
		initialReferrer = (String) value.get(FIELD_INITIAL_REFERRER);
		initialUserAgent = (String) value.get(FIELD_INITIAL_USER_AGENT);
		userAgentId = (String) value.get(FIELD_USER_AGENT_ID);
		clientIpAddress = (String) value.get(FIELD_CLIENT_IP_ADDRESS);
		clientHostName = (String) value.get(FIELD_CLIENT_HOST_NAME);
		clientUser = (String) value.get(FIELD_CLIENT_USER);
		clientIpIspName = (String) value.get(FIELD_CLIENT_IP_ISP_NAME);
		clientIpPostalCode = (String) value.get(FIELD_CLIENT_IP_POSTAL_CODE);
		cookie = (String) value.get(FIELD_COOKIE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		clientIpStateProvGeoId = (String) value
				.get(FIELD_CLIENT_IP_STATE_PROV_GEO_ID);
		clientIpCountryGeoId = (String) value
				.get(FIELD_CLIENT_IP_COUNTRY_GEO_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
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