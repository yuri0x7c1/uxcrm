package org.apache.ofbiz.security.securitygroup;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Security Group
 */
@FieldNameConstants
public class SecurityGroup implements Serializable {

	public static final long serialVersionUID = 4554846827061352448L;
	public static final String NAME = "SecurityGroup";
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
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

	public SecurityGroup(GenericValue value) {
		groupId = (String) value.get(FIELD_GROUP_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SecurityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SecurityGroup(value);
	}

	public static List<SecurityGroup> fromValues(List<GenericValue> values) {
		List<SecurityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SecurityGroup(value));
		}
		return entities;
	}
}