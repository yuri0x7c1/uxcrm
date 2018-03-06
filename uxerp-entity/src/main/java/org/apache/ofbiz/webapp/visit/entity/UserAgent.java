package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Agent
 */
public class UserAgent implements Serializable {

	public static final long serialVersionUID = 2249676890522011648L;
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

	public enum Fields {
		userAgentId, browserTypeId, platformTypeId, protocolTypeId, userAgentTypeId, userAgentMethodTypeId
	}

	public UserAgent(GenericValue value) {
		userAgentId = (String) value.get(Fields.userAgentId.name());
		browserTypeId = (String) value.get(Fields.browserTypeId.name());
		platformTypeId = (String) value.get(Fields.platformTypeId.name());
		protocolTypeId = (String) value.get(Fields.protocolTypeId.name());
		userAgentTypeId = (String) value.get(Fields.userAgentTypeId.name());
		userAgentMethodTypeId = (String) value.get(Fields.userAgentMethodTypeId
				.name());
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