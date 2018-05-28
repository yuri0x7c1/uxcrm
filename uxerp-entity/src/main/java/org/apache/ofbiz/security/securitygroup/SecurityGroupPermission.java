package org.apache.ofbiz.security.securitygroup;

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
public class SecurityGroupPermission implements Serializable {

	public static final long serialVersionUID = 7756175505672359936L;
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
		groupId, permissionId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SecurityGroupPermission(GenericValue value) {
		groupId = (String) value.get(Fields.groupId.name());
		permissionId = (String) value.get(Fields.permissionId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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