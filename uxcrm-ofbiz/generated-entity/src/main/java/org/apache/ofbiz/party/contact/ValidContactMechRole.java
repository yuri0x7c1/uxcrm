package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ValidContactMechRole implements Serializable {

	public static final long serialVersionUID = 7982450415923399680L;
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

	public ValidContactMechRole(GenericValue value) {
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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