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
 * User Agent Method Type
 */
@FieldNameConstants
public class UserAgentMethodType implements Serializable {

	public static final long serialVersionUID = 4290215243860395008L;
	public static final String NAME = "UserAgentMethodType";
	/**
	 * User Agent Method Type Id
	 */
	@Getter
	@Setter
	private String userAgentMethodTypeId;
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

	public UserAgentMethodType(GenericValue value) {
		userAgentMethodTypeId = (String) value
				.get(FIELD_USER_AGENT_METHOD_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UserAgentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserAgentMethodType(value);
	}

	public static List<UserAgentMethodType> fromValues(List<GenericValue> values) {
		List<UserAgentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserAgentMethodType(value));
		}
		return entities;
	}
}