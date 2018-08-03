package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Valid Contact Mech Role
 */
public class ValidContactMechRole implements Serializable {

	public static final long serialVersionUID = 3840865887390454784L;
	public static final String NAME = "ValidContactMechRole";
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
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
		roleTypeId, contactMechTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ValidContactMechRole(GenericValue value) {
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ValidContactMechRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ValidContactMechRole(value);
	}

	public static List<ValidContactMechRole> fromValues(
			List<GenericValue> values) {
		List<ValidContactMechRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ValidContactMechRole(value));
		}
		return entities;
	}
}