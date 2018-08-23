package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Tax Auth Info
 */
@FieldNameConstants
public class PartyTaxAuthInfo implements Serializable {

	public static final long serialVersionUID = 1682380868990899200L;
	public static final String NAME = "PartyTaxAuthInfo";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
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
	 * Party Tax Id
	 */
	@Getter
	@Setter
	private String partyTaxId;
	/**
	 * Is Exempt
	 */
	@Getter
	@Setter
	private String isExempt;
	/**
	 * Is Nexus
	 */
	@Getter
	@Setter
	private String isNexus;
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

	public PartyTaxAuthInfo(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		partyTaxId = (String) value.get(FIELD_PARTY_TAX_ID);
		isExempt = (String) value.get(FIELD_IS_EXEMPT);
		isNexus = (String) value.get(FIELD_IS_NEXUS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyTaxAuthInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyTaxAuthInfo(value);
	}

	public static List<PartyTaxAuthInfo> fromValues(List<GenericValue> values) {
		List<PartyTaxAuthInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyTaxAuthInfo(value));
		}
		return entities;
	}
}