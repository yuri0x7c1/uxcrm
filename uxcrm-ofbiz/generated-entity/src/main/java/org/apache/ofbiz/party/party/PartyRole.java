package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Role
 */
@FieldNameConstants
public class PartyRole implements Serializable {

	public static final long serialVersionUID = 2530653824389903360L;
	public static final String NAME = "PartyRole";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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

	public PartyRole(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyRole fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRole(value);
	}

	public static List<PartyRole> fromValues(List<GenericValue> values) {
		List<PartyRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRole(value));
		}
		return entities;
	}
}