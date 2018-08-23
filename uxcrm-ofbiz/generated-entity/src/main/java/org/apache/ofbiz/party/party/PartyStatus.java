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
 * Party Status
 */
@FieldNameConstants
public class PartyStatus implements Serializable {

	public static final long serialVersionUID = 1381080472685531136L;
	public static final String NAME = "PartyStatus";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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

	public PartyStatus(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyStatus(value);
	}

	public static List<PartyStatus> fromValues(List<GenericValue> values) {
		List<PartyStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyStatus(value));
		}
		return entities;
	}
}