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
 * Party Contact Mech
 */
@FieldNameConstants
public class PartyContactMech implements Serializable {

	public static final long serialVersionUID = 2347295051507180544L;
	public static final String NAME = "PartyContactMech";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Verified
	 */
	@Getter
	@Setter
	private String verified;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Years With Contact Mech
	 */
	@Getter
	@Setter
	private Long yearsWithContactMech;
	/**
	 * Months With Contact Mech
	 */
	@Getter
	@Setter
	private Long monthsWithContactMech;
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

	public PartyContactMech(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		allowSolicitation = (String) value.get(FIELD_ALLOW_SOLICITATION);
		extension = (String) value.get(FIELD_EXTENSION);
		verified = (String) value.get(FIELD_VERIFIED);
		comments = (String) value.get(FIELD_COMMENTS);
		yearsWithContactMech = (Long) value.get(FIELD_YEARS_WITH_CONTACT_MECH);
		monthsWithContactMech = (Long) value
				.get(FIELD_MONTHS_WITH_CONTACT_MECH);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContactMech(value);
	}

	public static List<PartyContactMech> fromValues(List<GenericValue> values) {
		List<PartyContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContactMech(value));
		}
		return entities;
	}
}