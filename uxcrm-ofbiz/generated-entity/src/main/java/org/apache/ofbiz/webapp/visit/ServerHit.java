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
 * Server Hit
 */
@FieldNameConstants
public class ServerHit implements Serializable {

	public static final long serialVersionUID = 1883136938459198464L;
	public static final String NAME = "ServerHit";
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Hit Start Date Time
	 */
	@Getter
	@Setter
	private Timestamp hitStartDateTime;
	/**
	 * Hit Type Id
	 */
	@Getter
	@Setter
	private String hitTypeId;
	/**
	 * Num Of Bytes
	 */
	@Getter
	@Setter
	private Long numOfBytes;
	/**
	 * Running Time Millis
	 */
	@Getter
	@Setter
	private Long runningTimeMillis;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Request Url
	 */
	@Getter
	@Setter
	private String requestUrl;
	/**
	 * Referrer Url
	 */
	@Getter
	@Setter
	private String referrerUrl;
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
	 * Internal Content Id
	 */
	@Getter
	@Setter
	private String internalContentId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Id By Ip Contact Mech Id
	 */
	@Getter
	@Setter
	private String idByIpContactMechId;
	/**
	 * Ref By Web Contact Mech Id
	 */
	@Getter
	@Setter
	private String refByWebContactMechId;

	public ServerHit(GenericValue value) {
		visitId = (String) value.get(FIELD_VISIT_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		hitStartDateTime = (Timestamp) value.get(FIELD_HIT_START_DATE_TIME);
		hitTypeId = (String) value.get(FIELD_HIT_TYPE_ID);
		numOfBytes = (Long) value.get(FIELD_NUM_OF_BYTES);
		runningTimeMillis = (Long) value.get(FIELD_RUNNING_TIME_MILLIS);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		requestUrl = (String) value.get(FIELD_REQUEST_URL);
		referrerUrl = (String) value.get(FIELD_REFERRER_URL);
		serverIpAddress = (String) value.get(FIELD_SERVER_IP_ADDRESS);
		serverHostName = (String) value.get(FIELD_SERVER_HOST_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		internalContentId = (String) value.get(FIELD_INTERNAL_CONTENT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		idByIpContactMechId = (String) value
				.get(FIELD_ID_BY_IP_CONTACT_MECH_ID);
		refByWebContactMechId = (String) value
				.get(FIELD_REF_BY_WEB_CONTACT_MECH_ID);
	}

	public static ServerHit fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new ServerHit(value);
	}

	public static List<ServerHit> fromValues(List<GenericValue> values) {
		List<ServerHit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ServerHit(value));
		}
		return entities;
	}
}