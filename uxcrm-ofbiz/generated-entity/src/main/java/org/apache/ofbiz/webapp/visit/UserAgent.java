package org.apache.ofbiz.webapp.visit;

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
public class UserAgent implements Serializable {

	public static final long serialVersionUID = 5732603051997737984L;
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

	public enum Fields {
		userAgentId, browserTypeId, platformTypeId, protocolTypeId, userAgentTypeId, userAgentMethodTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserAgent(GenericValue value) {
		userAgentId = (String) value.get(Fields.userAgentId.name());
		browserTypeId = (String) value.get(Fields.browserTypeId.name());
		platformTypeId = (String) value.get(Fields.platformTypeId.name());
		protocolTypeId = (String) value.get(Fields.protocolTypeId.name());
		userAgentTypeId = (String) value.get(Fields.userAgentTypeId.name());
		userAgentMethodTypeId = (String) value.get(Fields.userAgentMethodTypeId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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