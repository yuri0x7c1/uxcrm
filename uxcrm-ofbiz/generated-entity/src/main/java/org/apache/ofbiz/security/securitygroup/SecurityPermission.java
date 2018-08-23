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
 * Security Permission
 */
@FieldNameConstants
public class SecurityPermission implements Serializable {

	public static final long serialVersionUID = 83691460434384896L;
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

	public SecurityPermission(GenericValue value) {
		permissionId = (String) value.get(FIELD_PERMISSION_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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