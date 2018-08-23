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
 * Security Group Permission
 */
@FieldNameConstants
public class SecurityGroupPermission implements Serializable {

	public static final long serialVersionUID = 8689934030623060992L;
	public static final String NAME = "SecurityGroupPermission";
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Permission Id
	 */
	@Getter
	@Setter
	private String permissionId;
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

	public SecurityGroupPermission(GenericValue value) {
		groupId = (String) value.get(FIELD_GROUP_ID);
		permissionId = (String) value.get(FIELD_PERMISSION_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SecurityGroupPermission fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SecurityGroupPermission(value);
	}

	public static List<SecurityGroupPermission> fromValues(
			List<GenericValue> values) {
		List<SecurityGroupPermission> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SecurityGroupPermission(value));
		}
		return entities;
	}
}