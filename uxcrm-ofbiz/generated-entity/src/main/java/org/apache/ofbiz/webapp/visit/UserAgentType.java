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
 * User Agent Type
 */
@FieldNameConstants
public class UserAgentType implements Serializable {

	public static final long serialVersionUID = 6407500458305169408L;
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

	public UserAgentType(GenericValue value) {
		userAgentTypeId = (String) value.get(FIELD_USER_AGENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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