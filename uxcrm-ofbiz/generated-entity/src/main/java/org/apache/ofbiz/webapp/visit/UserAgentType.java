package org.apache.ofbiz.webapp.visit;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Agent Type
 */
public class UserAgentType implements Serializable {

	public static final long serialVersionUID = 6428873423177976832L;
	public static final String NAME = "UserAgentType";
	/**
	 * User Agent Type Id
	 */
	@Getter
	@Setter
	private String userAgentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		userAgentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserAgentType(GenericValue value) {
		userAgentTypeId = (String) value.get(Fields.userAgentTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static UserAgentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserAgentType(value);
	}

	public static List<UserAgentType> fromValues(List<GenericValue> values) {
		List<UserAgentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserAgentType(value));
		}
		return entities;
	}
}