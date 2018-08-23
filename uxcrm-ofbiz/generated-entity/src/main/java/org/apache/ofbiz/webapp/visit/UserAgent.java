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
 * User Agent
 */
@FieldNameConstants
public class UserAgent implements Serializable {

	public static final long serialVersionUID = 3981850475746522112L;
	public static final String NAME = "UserAgent";
	/**
	 * User Agent Id
	 */
	@Getter
	@Setter
	private String userAgentId;
	/**
	 * Browser Type Id
	 */
	@Getter
	@Setter
	private String browserTypeId;
	/**
	 * Platform Type Id
	 */
	@Getter
	@Setter
	private String platformTypeId;
	/**
	 * Protocol Type Id
	 */
	@Getter
	@Setter
	private String protocolTypeId;
	/**
	 * User Agent Type Id
	 */
	@Getter
	@Setter
	private String userAgentTypeId;
	/**
	 * User Agent Method Type Id
	 */
	@Getter
	@Setter
	private String userAgentMethodTypeId;
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

	public UserAgent(GenericValue value) {
		userAgentId = (String) value.get(FIELD_USER_AGENT_ID);
		browserTypeId = (String) value.get(FIELD_BROWSER_TYPE_ID);
		platformTypeId = (String) value.get(FIELD_PLATFORM_TYPE_ID);
		protocolTypeId = (String) value.get(FIELD_PROTOCOL_TYPE_ID);
		userAgentTypeId = (String) value.get(FIELD_USER_AGENT_TYPE_ID);
		userAgentMethodTypeId = (String) value
				.get(FIELD_USER_AGENT_METHOD_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UserAgent fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new UserAgent(value);
	}

	public static List<UserAgent> fromValues(List<GenericValue> values) {
		List<UserAgent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserAgent(value));
		}
		return entities;
	}
}