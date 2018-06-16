package org.apache.ofbiz.security.securitygroup;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Security Permission
 */
public class SecurityPermission implements Serializable {

	public static final long serialVersionUID = 5548139436907890688L;
	public static final String NAME = "SecurityPermission";
	/**
	 * Permission Id
	 */
	@Getter
	@Setter
	private String permissionId;
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
		permissionId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SecurityPermission(GenericValue value) {
		permissionId = (String) value.get(Fields.permissionId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SecurityPermission fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SecurityPermission(value);
	}

	public static List<SecurityPermission> fromValues(List<GenericValue> values) {
		List<SecurityPermission> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SecurityPermission(value));
		}
		return entities;
	}
}