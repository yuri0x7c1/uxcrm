package org.apache.ofbiz.webapp.visit;

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
public class ServerHit implements Serializable {

	public static final long serialVersionUID = 1447766197686744064L;
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

	public enum Fields {
		visitId, contentId, hitStartDateTime, hitTypeId, numOfBytes, runningTimeMillis, userLoginId, statusId, requestUrl, referrerUrl, serverIpAddress, serverHostName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, internalContentId, partyId, idByIpContactMechId, refByWebContactMechId
	}

	public ServerHit(GenericValue value) {
		visitId = (String) value.get(Fields.visitId.name());
		contentId = (String) value.get(Fields.contentId.name());
		hitStartDateTime = (Timestamp) value
				.get(Fields.hitStartDateTime.name());
		hitTypeId = (String) value.get(Fields.hitTypeId.name());
		numOfBytes = (Long) value.get(Fields.numOfBytes.name());
		runningTimeMillis = (Long) value.get(Fields.runningTimeMillis.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		statusId = (String) value.get(Fields.statusId.name());
		requestUrl = (String) value.get(Fields.requestUrl.name());
		referrerUrl = (String) value.get(Fields.referrerUrl.name());
		serverIpAddress = (String) value.get(Fields.serverIpAddress.name());
		serverHostName = (String) value.get(Fields.serverHostName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		internalContentId = (String) value.get(Fields.internalContentId.name());
		partyId = (String) value.get(Fields.partyId.name());
		idByIpContactMechId = (String) value.get(Fields.idByIpContactMechId
				.name());
		refByWebContactMechId = (String) value.get(Fields.refByWebContactMechId
				.name());
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